//  File ContactGenerator
//  Sample code was taken from:
//  http://www.csharpprogramming.tips/2013/06/RandomDoxGenerator.html
//  Other useful methods are there.
//
// Requirements:
// Exapand on the below example to create a CSV file (https://en.wikipedia.org/wiki/Comma-separated_values)
// For contacts with the following data
// First Name
// Last Name
// Street Number
// Street
// City
// 
// Province
// Country  == Canada ( Simply insert "canada")
// Postal Code  
// 
// Generate 20 records in the file, submit end of class


using System;
using System.IO;

// Describes what is a namespace 
// https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/namespaces/
namespace MSCDA5510
{
    class ContactGenerator
    {
        // instance of random number generator
        Random rand = new Random();

        static void Main(string[] args)
        {
            // instance of ContactGenerator
            ContactGenerator dg =  new ContactGenerator();
        }

        public ContactGenerator()
        {
            String COMMA = ",";

            //TODO replace with your local location
            String outputFileName = @"C: \Users\sarbo\Desktop\Assignment1\MCDA5510_Assignments\ConsoleApp1\ConsoleApp1\customers.csv";

            if (File.Exists(outputFileName))
            {
                Console.Write(" File " + outputFileName + " exists, appending");
            }
            StreamWriter fileStream = new StreamWriter(outputFileName, true);

            // Write Header
            fileStream.Write("First Name");
            fileStream.Write(COMMA);
            fileStream.Write("Last Name");
            fileStream.WriteLine();

            for (int i = 0; i < 20; i++)
            {
                fileStream.Write(GenerateFirstName());
                fileStream.Write(COMMA);
                fileStream.Write(GenerateLastName());
                fileStream.Write(COMMA);
                fileStream.Write(GenerateCity());
                fileStream.Write(COMMA);
                fileStream.Write(GenerateStreet());
                fileStream.Write(COMMA);
                fileStream.Write(GenerateStreetName());
                fileStream.Write(COMMA);
                fileStream.Write(GenerateCountry());
                fileStream.Write(COMMA);
                fileStream.Write(GeneratePostalCode());
                fileStream.Write(COMMA);
                fileStream.Write(GenerateProvince());
                fileStream.WriteLine();
            }
            fileStream.Close();
        }

        public string GenerateFirstName()
        {
       // C: \Users\sarbo\Desktop\Assignment1\MCDA5510_Assignments\ConsoleApp1\ConsoleApp1
       //  String firstNames = @"C:\Users\dpenny\Desktop\FileWrite\ConsoleApp1\ConsoleApp1\firstNames.txt";
            String firstNames = @"C: \Users\sarbo\Desktop\Assignment1\MCDA5510_Assignments\ConsoleApp1\ConsoleApp1\firstNames.txt";

            return ReturnRandomLine(firstNames);
        }

        public string GenerateLastName()
        {
            String lastNames = @"C: \Users\sarbo\Desktop\Assignment1\MCDA5510_Assignments\ConsoleApp1\ConsoleApp1\lastNames.txt";
            return ReturnRandomLine(lastNames);
        }

        public string GenerateCity()
        {
            String city = @"C: \Users\sarbo\Desktop\Assignment1\MCDA5510_Assignments\ConsoleApp1\ConsoleApp1\City.txt";
            return ReturnRandomLine(city);
        }

        public string GenerateStreetName()
        {
            String StreetName = @"C: \Users\sarbo\Desktop\Assignment1\MCDA5510_Assignments\ConsoleApp1\ConsoleApp1\StreetName.txt";
            return ReturnRandomLine(StreetName);
        }

        public string GenerateStreet()
        {
            String street = @"C: \Users\sarbo\Desktop\Assignment1\MCDA5510_Assignments\ConsoleApp1\ConsoleApp1\StreetNumber.txt";
            return ReturnRandomLine(street);
        }

        public string GenerateProvince()
        {
            String province = @"C: \Users\sarbo\Desktop\Assignment1\MCDA5510_Assignments\ConsoleApp1\ConsoleApp1\province.txt";
            return ReturnRandomLine(province);
        }
        public string GeneratePostalCode()
        {
            String pcode = @"C: \Users\sarbo\Desktop\Assignment1\MCDA5510_Assignments\ConsoleApp1\ConsoleApp1\PostCode.txt";
            return ReturnRandomLine(pcode);
        }
        public string GenerateCountry()
        {
            String country = @"C: \Users\sarbo\Desktop\Assignment1\MCDA5510_Assignments\ConsoleApp1\ConsoleApp1\Country.txt";
            return ReturnRandomLine(country);
        }

        // Gets a line from a file
        public string ReturnRandomLine(string FileName)
        {
            string sReturn = string.Empty;

            using (FileStream myFile = new FileStream(FileName, FileMode.Open, FileAccess.Read))
            {
                using (StreamReader myStream = new StreamReader(myFile))
                {

                    // just cast it to int because we know it will be less than 
                    int fileLength = (int)myFile.Length;

                    // Seek file stream pointer to a rand position...
                    myStream.BaseStream.Seek(rand.Next(1,fileLength), SeekOrigin.Begin);

                    // Read the rest of that line.
                    myStream.ReadLine();

                    // Return the next, full line...
                    sReturn = myStream.ReadLine();
                }
            }

            // If our random file position was too close to the end of the file, it will return an empty string
            // I avoided a while loop in the case that the file is empty or contains only one line
            if (System.String.IsNullOrWhiteSpace(sReturn))
            {
                sReturn = ReturnRandomLine(FileName);
            }

            return sReturn;
        }
    }




}

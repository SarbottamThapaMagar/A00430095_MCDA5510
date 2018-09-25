
public class CustomerInfo {

	private String firstName;
	private String secondName;
	private String postalCode;
	private String province;
	private String streeName;
	private String city;
	private String country;
	private String email;
	private String streetNumber;
	private String phoneNumber;

	public CustomerInfo(String firstName, String secondName, String postalCode, String province, String streeName,
			String city, String country, String email, String streetNumber, String phoneNumber) {
		this.streetNumber = streetNumber;
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.secondName = secondName;
		this.postalCode = postalCode;
		this.province = province;
		this.streeName = streeName;
		this.city = city;
		this.country = country;
		this.email = email;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSeonctName(String secondName) {
		this.secondName = secondName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStreeName() {
		return streeName;
	}

	public void setStreeName(String streeName) {
		this.streeName = streeName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

package model;

public class Driver {
    private String name;
    private String nic;
    private String licenseNo;
    private String address;
    private String contact;

    public Driver(String name, String nic, String licenseNo, String address, String contact) {
        this.setName(name);
        this.setNic(nic);
        this.setLicenseNo(licenseNo);
        this.setAddress(address);
        this.setContact(contact);
    }

    public Driver() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}

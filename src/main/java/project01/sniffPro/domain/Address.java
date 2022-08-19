package project01.sniffPro.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String region;
    private String street;
    private String dtlInfo;

    protected Address() {
    }

    public Address(String region, String street, String dtlInfo) {
        this.region = region;
        this.street = street;
        this.dtlInfo = dtlInfo;
    }

}

package project01.sniffPro.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String region;
    private String street;
    private String dtlInfo;

}

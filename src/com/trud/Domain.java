package com.trud;

/*It's object for loging*/

public class Domain {
    //single domain name for example https://ua.trud.com
    private String domain;
    //amount of vacancies witch located on the site
    private String amountOfVacancies;

    public Domain(String domain, String amountOfVacancies) {
        this.domain = domain;
        this.amountOfVacancies = amountOfVacancies;
    }

    public String getDomain() {
        return domain;
    }

    public String getAmountOfVacancies() {
        return amountOfVacancies;
    }

    @Override
    public String toString() {
        return "domain= '" + domain + '\'' +
                ", amountOfVacinsies='" + amountOfVacancies + '\'';
    }
}

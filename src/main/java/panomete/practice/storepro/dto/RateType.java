package panomete.practice.storepro.dto;

public enum RateType {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17");

    String rate;

    RateType(String rate) {
        this.rate = rate;
    }

    public String getRate() {
        return rate;
    }
}

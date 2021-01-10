package org.kaelbastos.Domain.Entities.Service;

public enum ServiceCategory {
    HomeCleansing("home cleansing"),
    kitchenCleansing("kitchen cleansing"),
    CompleteCleansing("complete cleansing"),
    Organization("organization"),
    Laundry("laundry"),
    IronClothes("iron clothes"),
    CompleteLaundry("complete laundry"),
    Complete("complete"),
    Other("other"),
    None("None");

    public String value;

    ServiceCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

package pl.akademiaspecjalistowit.jokeapp.model;

import java.util.UUID;

public class JokeDto {
    private String setup;
    private String delivery;
    private String category;

    public JokeDto(String setup, String delivery, String category) {
        this.setup = setup;
        this.delivery = delivery;
        this.category = category;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

package pl.akademiaspecjalistowit.jokeapp.model;

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

    public String getDelivery() {
        return delivery;
    }

    public String getCategory() {
        return category;
    }
}

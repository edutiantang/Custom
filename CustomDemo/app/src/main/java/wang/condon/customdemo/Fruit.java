package wang.condon.customdemo;

public class Fruit {

	private String name;

	private int imageId;

    private int count;

	public Fruit(String name, int imageId, int count) {
		this.name = name;
		this.imageId = imageId;
        this.count = count;
	}

    public int getCount() {
        return count;
    }
    public String getName() {
		return name;
	}

	public int getImageId() {
		return imageId;
	}

}

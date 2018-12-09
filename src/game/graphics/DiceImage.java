package game.graphics;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class DiceImage {
    private List<Image> diceImages;

    public DiceImage() {
        this(6);
    }

    public DiceImage(int NumberOfSides) {
        diceImages = new ArrayList<>();
        for (int i = 1; i <= NumberOfSides; i++) this.diceImages.add(this.fileToImage(i + ".jpeg"));
    }

    public List<Image> getDiceImages() {
        return this.diceImages;
    }

    public void setDiceImages(List<Image> diceImages) {
        this.diceImages = diceImages;
    }

    public Image getDiceFaceImage(int faceNumber) {
        return this.diceImages.get(faceNumber - 1);
    }

    public Image fileToImage(String resourceName) {
        return new Image(getClass().getResource(resourceName).toExternalForm());
    }
}

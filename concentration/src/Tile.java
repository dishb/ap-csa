public class Tile {   
    private boolean isMatched;
    private boolean isShowing;
    private String value;
    private String hidden;
    private String matched;

    public Tile(String value) {
        this.value = value;

        isMatched = false;
        isShowing = false;
        hidden =  "_____";
        matched = "  *  ";
    }

    public String getValue() {
        return value;
    }

    public String getHidden() {
        return hidden;
    }

    public void show() {
        isShowing = true;
    }

    public void hide() {
        isShowing = false;
    }

    public boolean isShowingValue() {
        return isShowing;
    }

    public void foundMatch() {
        isMatched = true;
        value = matched;
        hidden = matched;
    }

    public boolean matched() {
        return isMatched;
    }

    public boolean equals(Tile tile) {      
        if (this.value.equals(tile.value)) {
            return true;
        }

        return false;
    }

    public String toString() {
        return value;
    }
}

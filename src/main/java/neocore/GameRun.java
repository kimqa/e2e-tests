package neocore;

public class GameRun {
    private String platform;
    private String type;

    @Override
    public String toString() {
        return "GameRun{" +
                "platform='" + platform + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public GameRun(String platform, String type) {
        this.platform = platform;
        this.type = type;
    }
    public GameRun() {

    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

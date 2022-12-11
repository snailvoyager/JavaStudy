package effective.item01;

public class Settings {

    private boolean useAutoSteering;
    private boolean useABS;

    private Settings() {}

    private static final Settings SETTINGS = new Settings();

    public static Settings newInstance() {  //호출될 때마다 인스턴스를 새로 생성하지 않아도 된다
        return SETTINGS;
    }
}

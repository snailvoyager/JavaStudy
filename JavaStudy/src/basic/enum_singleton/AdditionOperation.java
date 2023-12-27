package basic.enum_singleton;

public class AdditionOperation implements Operation {
    @Override
    public void performOperation(String rawTemplate) {
        System.out.println("Performing addition operation");
        System.out.println(this);
        processFirst(rawTemplate);
    }

    private void processFirst(String rawTemplate) {
        System.out.println("processing first..." + rawTemplate);
    }
}

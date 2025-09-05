package com.ocp.zert.assessment;

public abstract class AssessmentQuestion2 {
    public String recipient;
    public abstract void sendMessage(); // public abstract final void sendMessage();
    public static void main(String[] args) {

        AssessmentQuestion2 m = new TextAssessmentQuestion2();
        m.recipient = "1234567890";
        m.sendMessage();
    }
    static class TextAssessmentQuestion2 extends AssessmentQuestion2 {
        public final void sendMessage() {
            System.out.println("Text message to " + recipient);
        }
    }
}
package liga.medical.medicalmonitoring.core.solid;
// 2 принцип - oped-closed principle. Его нарушением является метод sendMessage, т.к. метод не универсален
// и при потребности отправить сообщение через любую новую службу придется модифицировать метод и менять логику.
public class AntiO {

    public void sendMessage(String messageType, String message) {
        if (messageType.equals("email")) {
//            do smth with email
        }
        if (messageType.equals("sms")) {
//            do smth with sms
        }
//
    }
}

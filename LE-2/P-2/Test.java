public class Test {
    public static void main(String[] args) {
        /* voice.hear();
        voice.prepareVoice(); Error => Exception in thread "main" java.lang.NullPointerException
                                    	at Voice.hear(Voice.java:14)
                                    	at Test.main(Test.java:4) */
                                    	
        Voice2 v = new Voice2();
        v.templateMethod();
    }
}
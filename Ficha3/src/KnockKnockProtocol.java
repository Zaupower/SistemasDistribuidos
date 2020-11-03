public class KnockKnockProtocol {
    private static final int WAITING = 0;
    private static final int SENTKNOCKKNOCK = 1;
    private static final int SENTCLUE = 2;
    private static final int ANOTHER = 3;
    private static final int NUMJOKES = 5;
    private int state = 0;
    private int currentJoke = 0;
    private String[] clues = new String[]{"Turnip", "Little Old Lady", "Atch", "Who", "Who"};
    private String[] answers = new String[]{"Turnip the heat, it's cold in here!", "I didn't know you could yodel!", "Bless you!", "Is there an owl in here?", "Is there an echo in here?"};

    public KnockKnockProtocol() {
    }

    public String processInput(String theInput) {
        String theOutput = null;
        if (this.state == 0) {
            theOutput = "Knock! Knock!";
            this.state = 1;
        } else if (this.state == 1) {
            if (theInput.equalsIgnoreCase("Who's there?")) {
                theOutput = this.clues[this.currentJoke];
                this.state = 2;
            } else {
                theOutput = "You're supposed to say \"Who's there?\"! Try again. Knock! Knock!";
            }
        } else if (this.state == 2) {
            String var10001 = this.clues[this.currentJoke];
            String var10000;
            if (theInput.equalsIgnoreCase(var10001 + " who?")) {
                var10000 = this.answers[this.currentJoke];
                theOutput = var10000 + " Want another? (y/n)";
                this.state = 3;
            } else {
                var10000 = this.clues[this.currentJoke];
                theOutput = "You're supposed to say \"" + var10000 + " who?\"! Try again. Knock! Knock!";
                this.state = 1;
            }
        } else if (this.state == 3) {
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = "Knock! Knock!";
                if (this.currentJoke == 4) {
                    this.currentJoke = 0;
                } else {
                    ++this.currentJoke;
                }

                this.state = 1;
            } else {
                theOutput = "Bye.";
                this.state = 0;
            }
        }

        return theOutput;
    }
}

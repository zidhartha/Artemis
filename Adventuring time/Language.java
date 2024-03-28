

public enum Language {
    ENGLISH() {
        @Override
        public String getLocalizedChristmasGreeting(String greeterName) {
            return greeterName + " wishes you a Merry Christmas!";
        }
    },
    GERMAN() {
        @Override
        public String getLocalizedChristmasGreeting(String greeterName) {
            return "Fröhliche Weihnachten wünscht dir " + greeterName + "!";
        }
    },
    GEORGIAN() {
        @Override
        public String getLocalizedChristmasGreeting(String greeterName) {
            return greeterName + " გილოცავს შობა-ახალ წელს!";
        }
    };

    public abstract String getLocalizedChristmasGreeting(String greeterName);
}

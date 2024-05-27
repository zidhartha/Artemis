

public interface Thesis {
    enum State {
        INTRO, SETUP, EXPERIMENTS, CONCLUSION, REFS, FINISHED
    }
    String intro();
    String setup();
    String experiments();
    String conclusion();
    String refs();
}

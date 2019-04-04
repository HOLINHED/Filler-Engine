package filler.input;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public enum Key {

    SPACE(32),
    ESC(27),
    ESCAPE(27),
    DEL(8),
    DELETE(8),
    ENTER(13),
    SHIFT(16),
    CAPS(20),
    CTRL(17),
    CONTROL(17),
    ALT(18),
    META(91),
    ARLEFT(37),
    ARROWLEFT(37),
    ARUP(38),
    ARROWUP(38),
    ARRIGHT(39),
    ARROWRIGHT(39),
    ARDOWN(40),
    ARROWDOWN(40),
    ;

    private final int keyCode;

    Key(int keyCode) {
        this.keyCode = keyCode;
    }

    public int getKeyCode() {
        return keyCode;
    }

}

public interface GameFunctionality {

    int SCREEN_WIDTH = 600;
    int SCREEN_HEIGHT = 600;
    int UNIT_SIZE = 25;
    int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    int DELAY = 75;

    int[] x = new int[GAME_UNITS];
    int[] y = new int[GAME_UNITS];

    int[] x2 = new int[GAME_UNITS];
    int[] y2 = new int[GAME_UNITS];

}

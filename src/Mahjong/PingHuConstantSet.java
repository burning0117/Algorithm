package Mahjong;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PingHuConstantSet {
    /**
     * 所有顺子
     */
    private int[][] sequence = {
            {0, 1, 2},
            {1, 2, 3},
            {2, 3, 4},
            {3, 4, 5},
            {4, 5, 6},
            {5, 6, 7},
            {6, 7, 8},

            {9, 10, 11},
            {10, 11, 12},
            {11, 12, 13},
            {12, 13, 14},
            {13, 14, 15},
            {14, 15, 16},
            {15, 16, 17},

            {18, 19, 20},
            {19, 20, 21},
            {20, 21, 22},
            {21, 22, 23},
            {22, 23, 24},
            {23, 24, 25},
            {24, 25, 26},

            {27, 28, 29},
            {28, 29, 30},
            {27, 28, 30},
            {27, 29, 30},

            {31, 32, 33}
    };
    /**
     * 所有刻子
     */
    int triple[][] = {
            {0, 0, 0},
            {1, 1, 1},
            {2, 2, 2},
            {3, 3, 3},
            {4, 4, 4},
            {5, 5, 5},
            {6, 6, 6},
            {7, 7, 7},
            {8, 8, 8},
            {9, 9, 9},
            {10, 10, 10},
            {11, 11, 11},
            {12, 12, 12},
            {13, 13, 13},
            {14, 14, 14},
            {15, 15, 15},
            {16, 16, 16},
            {17, 17, 17},
            {18, 18, 18},
            {19, 19, 19},
            {20, 20, 20},
            {21, 21, 21},
            {22, 22, 22},
            {23, 23, 23},
            {24, 24, 24},
            {25, 25, 25},
            {26, 26, 26},
            {27, 27, 27},
            {28, 28, 28},
            {29, 29, 29},
            {30, 30, 30},
            {31, 31, 31},
            {32, 32, 32},
            {33, 33, 33}
    };

    /**
     * 万筒条
     */
    private Set<Long> wttSet = new HashSet<>();
    /**
     * 风牌
     */
    private Set<Long> windSet = new HashSet<>();
    /**
     * 箭牌
     */
    private Set<Long> arrowSet = new HashSet<>();

    public PingHuConstantSet() {

        int[] tiles = new int[34];
        //4个顺子
        for (int j = 0; j < sequence.length; j++) {
            for (int k = 0; k < sequence.length; k++) {
                for (int l = 0; l < sequence.length; l++) {
                    for (int m = 0; m < sequence.length; m++) {
                        tiles[sequence[j][0]]++;
                        tiles[sequence[j][1]]++;
                        tiles[sequence[j][2]]++;
                        tiles[sequence[k][0]]++;
                        tiles[sequence[k][1]]++;
                        tiles[sequence[k][2]]++;
                        tiles[sequence[l][0]]++;
                        tiles[sequence[l][1]]++;
                        tiles[sequence[l][2]]++;
                        tiles[sequence[m][0]]++;
                        tiles[sequence[m][1]]++;
                        tiles[sequence[m][2]]++;
                        if (tiles[sequence[j][0]] > 6
                                || tiles[sequence[j][1]] > 6
                                || tiles[sequence[j][2]] > 6
                                || tiles[sequence[k][0]] > 6
                                || tiles[sequence[k][1]] > 6
                                || tiles[sequence[k][2]] > 6
                                || tiles[sequence[l][0]] > 6
                                || tiles[sequence[l][1]] > 6
                                || tiles[sequence[l][2]] > 6
                                || tiles[sequence[m][0]] > 6
                                || tiles[sequence[m][1]] > 6
                                || tiles[sequence[m][2]] > 6) {
                            tiles[sequence[j][0]]--;
                            tiles[sequence[j][1]]--;
                            tiles[sequence[j][2]]--;
                            tiles[sequence[k][0]]--;
                            tiles[sequence[k][1]]--;
                            tiles[sequence[k][2]]--;
                            tiles[sequence[l][0]]--;
                            tiles[sequence[l][1]]--;
                            tiles[sequence[l][2]]--;
                            tiles[sequence[m][0]]--;
                            tiles[sequence[m][1]]--;
                            tiles[sequence[m][2]]--;
                            Arrays.fill(tiles, 0);
                            continue;
                        } else {
                            addByte(tiles);
                            Arrays.fill(tiles, 0);
                        }
                    }
                }
            }
        }
        //3个顺子+1个刻子
        for (int j = 0; j < sequence.length; j++) {
            for (int k = 0; k < sequence.length; k++) {
                for (int l = 0; l < sequence.length; l++) {
                    for (int m = 0; m < triple.length; m++) {
                        tiles[sequence[j][0]]++;
                        tiles[sequence[j][1]]++;
                        tiles[sequence[j][2]]++;
                        tiles[sequence[k][0]]++;
                        tiles[sequence[k][1]]++;
                        tiles[sequence[k][2]]++;
                        tiles[sequence[l][0]]++;
                        tiles[sequence[l][1]]++;
                        tiles[sequence[l][2]]++;
                        tiles[triple[m][0]] += 3;
                        if (tiles[sequence[j][0]] > 6
                                || tiles[sequence[j][1]] > 6
                                || tiles[sequence[j][2]] > 6
                                || tiles[sequence[k][0]] > 6
                                || tiles[sequence[k][1]] > 6
                                || tiles[sequence[k][2]] > 6
                                || tiles[sequence[l][0]] > 6
                                || tiles[sequence[l][1]] > 6
                                || tiles[sequence[l][2]] > 6
                                || tiles[triple[m][0]] > 6) {
                            tiles[sequence[j][0]]--;
                            tiles[sequence[j][1]]--;
                            tiles[sequence[j][2]]--;
                            tiles[sequence[k][0]]--;
                            tiles[sequence[k][1]]--;
                            tiles[sequence[k][2]]--;
                            tiles[sequence[l][0]]--;
                            tiles[sequence[l][1]]--;
                            tiles[sequence[l][2]]--;
                            tiles[triple[m][0]] -= 3;
                            Arrays.fill(tiles, 0);
                            continue;
                        } else {
                            addByte(tiles);
                            Arrays.fill(tiles, 0);
                        }
                    }
                }
            }
        }
        //2个顺子+2个刻子
        for (int j = 0; j < sequence.length; j++) {
            for (int k = 0; k < sequence.length; k++) {
                for (int l = 0; l < triple.length; l++) {
                    for (int m = 0; m < triple.length; m++) {
                        tiles[sequence[j][0]]++;
                        tiles[sequence[j][1]]++;
                        tiles[sequence[j][2]]++;
                        tiles[sequence[k][0]]++;
                        tiles[sequence[k][1]]++;
                        tiles[sequence[k][2]]++;
                        tiles[triple[l][0]] += 3;
                        tiles[triple[m][0]] += 3;
                        if (tiles[sequence[j][0]] > 6
                                || tiles[sequence[j][1]] > 6
                                || tiles[sequence[j][2]] > 6
                                || tiles[sequence[k][0]] > 6
                                || tiles[sequence[k][1]] > 6
                                || tiles[sequence[k][2]] > 6
                                || (tiles[triple[l][0]]) > 6
                                || (tiles[triple[m][0]]) > 6) {
                            tiles[sequence[j][0]]--;
                            tiles[sequence[j][1]]--;
                            tiles[sequence[j][2]]--;
                            tiles[sequence[k][0]]--;
                            tiles[sequence[k][1]]--;
                            tiles[sequence[k][2]]--;
                            tiles[triple[l][0]] -= 3;
                            tiles[triple[m][0]] -= 3;
                            Arrays.fill(tiles, 0);
                            continue;
                        } else {
                            addByte(tiles);
                            Arrays.fill(tiles, 0);
                        }

                    }
                }
            }
        }
        //1个顺子+3个刻子
        for (int j = 0; j < sequence.length; j++) {
            for (int k = 0; k < triple.length; k++) {
                for (int l = 0; l < triple.length; l++) {
                    for (int m = 0; m < triple.length; m++) {
                        tiles[sequence[j][0]]++;
                        tiles[sequence[j][1]]++;
                        tiles[sequence[j][2]]++;
                        tiles[triple[k][0]] += 3;
                        tiles[triple[l][0]] += 3;
                        tiles[triple[m][0]] += 3;
                        if (tiles[sequence[j][0]] > 6
                                || tiles[sequence[j][1]] > 6
                                || tiles[sequence[j][2]] > 6
                                || (tiles[triple[k][0]]) > 6
                                || (tiles[triple[l][0]]) > 6
                                || (tiles[triple[m][0]]) > 6) {
                            tiles[sequence[j][0]]--;
                            tiles[sequence[j][1]]--;
                            tiles[sequence[j][2]]--;
                            tiles[triple[k][0]] -= 3;
                            tiles[triple[l][0]] -= 3;
                            tiles[triple[m][0]] -= 3;
                            Arrays.fill(tiles, 0);
                            continue;
                        } else {
                            addByte(tiles);
                            Arrays.fill(tiles, 0);
                        }
                    }
                }
            }
        }
        //4个刻子
        for (int j = 0; j < triple.length; j++) {
            for (int k = 0; k < triple.length; k++) {
                for (int l = 0; l < triple.length; l++) {
                    for (int m = 0; m < triple.length; m++) {
                        tiles[triple[j][0]] += 3;
                        tiles[triple[k][0]] += 3;
                        tiles[triple[l][0]] += 3;
                        tiles[triple[m][0]] += 3;
                        if (tiles[triple[j][0]] > 6
                                || tiles[triple[k][0]] > 6
                                || tiles[triple[l][0]] > 6
                                || tiles[triple[m][0]] > 6) {
                            tiles[triple[j][0]] -= 3;
                            tiles[triple[k][0]] -= 3;
                            tiles[triple[l][0]] -= 3;
                            tiles[triple[m][0]] -= 3;
                            Arrays.fill(tiles, 0);
                            continue;
                        } else {
                            addByte(tiles);
                            Arrays.fill(tiles, 0);
                        }
                    }
                }
            }
        }

        //3个顺子
        for (int j = 0; j < sequence.length; j++) {
            for (int k = 0; k < sequence.length; k++) {
                for (int l = 0; l < sequence.length; l++) {
                    tiles[sequence[j][0]]++;
                    tiles[sequence[j][1]]++;
                    tiles[sequence[j][2]]++;
                    tiles[sequence[k][0]]++;
                    tiles[sequence[k][1]]++;
                    tiles[sequence[k][2]]++;
                    tiles[sequence[l][0]]++;
                    tiles[sequence[l][1]]++;
                    tiles[sequence[l][2]]++;
                    if (tiles[sequence[j][0]] > 6
                            || tiles[sequence[j][1]] > 6
                            || tiles[sequence[j][2]] > 6
                            || tiles[sequence[k][0]] > 6
                            || tiles[sequence[k][1]] > 6
                            || tiles[sequence[k][2]] > 6
                            || tiles[sequence[l][0]] > 6
                            || tiles[sequence[l][1]] > 6
                            || tiles[sequence[l][2]] > 6) {
                        tiles[sequence[j][0]]--;
                        tiles[sequence[j][1]]--;
                        tiles[sequence[j][2]]--;
                        tiles[sequence[k][0]]--;
                        tiles[sequence[k][1]]--;
                        tiles[sequence[k][2]]--;
                        tiles[sequence[l][0]]--;
                        tiles[sequence[l][1]]--;
                        tiles[sequence[l][2]]--;
                        Arrays.fill(tiles, 0);
                        continue;
                    } else {
                        addByte(tiles);
                        Arrays.fill(tiles, 0);
                    }

                }
            }
        }
        //2个顺子+1个刻子
        for (int j = 0; j < sequence.length; j++) {
            for (int k = 0; k < sequence.length; k++) {
                for (int l = 0; l < triple.length; l++) {
                    tiles[sequence[j][0]]++;
                    tiles[sequence[j][1]]++;
                    tiles[sequence[j][2]]++;
                    tiles[sequence[k][0]]++;
                    tiles[sequence[k][1]]++;
                    tiles[sequence[k][2]]++;
                    tiles[triple[l][0]] += 3;
                    if (tiles[sequence[j][0]] > 6
                            || tiles[sequence[j][1]] > 6
                            || tiles[sequence[j][2]] > 6
                            || tiles[sequence[k][0]] > 6
                            || tiles[sequence[k][1]] > 6
                            || tiles[sequence[k][2]] > 6
                            || tiles[triple[l][0]] > 6) {
                        tiles[sequence[j][0]]--;
                        tiles[sequence[j][1]]--;
                        tiles[sequence[j][2]]--;
                        tiles[sequence[k][0]]--;
                        tiles[sequence[k][1]]--;
                        tiles[sequence[k][2]]--;
                        tiles[triple[l][0]] -= 3;
                        Arrays.fill(tiles, 0);
                        continue;
                    } else {
                        addByte(tiles);
                        Arrays.fill(tiles, 0);
                    }

                }
            }
        }
        //1个顺子+2个刻子
        for (int j = 0; j < sequence.length; j++) {
            for (int k = 0; k < triple.length; k++) {
                for (int l = 0; l < triple.length; l++) {
                    tiles[sequence[j][0]]++;
                    tiles[sequence[j][1]]++;
                    tiles[sequence[j][2]]++;
                    tiles[triple[k][0]] += 3;
                    tiles[triple[l][0]] += 3;
                    if (tiles[sequence[j][0]] > 6
                            || tiles[sequence[j][1]] > 6
                            || tiles[sequence[j][2]] > 6
                            || tiles[triple[k][0]] > 6
                            || tiles[triple[l][0]] > 6) {
                        tiles[sequence[j][0]]--;
                        tiles[sequence[j][1]]--;
                        tiles[sequence[j][2]]--;
                        tiles[triple[k][0]] -= 3;
                        tiles[triple[l][0]] -= 3;
                        Arrays.fill(tiles, 0);
                        continue;
                    } else {
                        addByte(tiles);
                        Arrays.fill(tiles, 0);
                    }

                }
            }
        }
        //3个刻子
        for (int j = 0; j < triple.length; j++) {
            for (int k = 0; k < triple.length; k++) {
                for (int l = 0; l < triple.length; l++) {
                    tiles[triple[j][0]] += 3;
                    tiles[triple[k][0]] += 3;
                    tiles[triple[l][0]] += 3;
                    if (tiles[triple[j][0]] > 6
                            || tiles[triple[k][0]] > 6
                            || tiles[triple[l][0]] > 6) {
                        tiles[triple[j][0]] -= 3;
                        tiles[triple[k][0]] -= 3;
                        tiles[triple[l][0]] -= 3;
                        Arrays.fill(tiles, 0);
                        continue;
                    } else {
                        addByte(tiles);
                        Arrays.fill(tiles, 0);
                    }
                }
            }
        }
        //2个顺子
        for (int j = 0; j < sequence.length; j++) {
            for (int k = 0; k < sequence.length; k++) {
                tiles[sequence[j][0]]++;
                tiles[sequence[j][1]]++;
                tiles[sequence[j][2]]++;
                tiles[sequence[k][0]]++;
                tiles[sequence[k][1]]++;
                tiles[sequence[k][2]]++;
                if (tiles[sequence[j][0]] > 6
                        || tiles[sequence[j][1]] > 6
                        || tiles[sequence[j][2]] > 6
                        || tiles[sequence[k][0]] > 6
                        || tiles[sequence[k][1]] > 6
                        || tiles[sequence[k][2]] > 6) {
                    tiles[sequence[j][0]]--;
                    tiles[sequence[j][1]]--;
                    tiles[sequence[j][2]]--;
                    tiles[sequence[k][0]]--;
                    tiles[sequence[k][1]]--;
                    tiles[sequence[k][2]]--;
                    Arrays.fill(tiles, 0);
                    continue;
                } else {
                    addByte(tiles);
                    Arrays.fill(tiles, 0);
                }
            }
        }
        //1个顺子+1个刻子
        for (int j = 0; j < sequence.length; j++) {
            for (int k = 0; k < triple.length; k++) {
                tiles[sequence[j][0]]++;
                tiles[sequence[j][1]]++;
                tiles[sequence[j][2]]++;
                tiles[triple[k][0]] += 3;
                if (tiles[sequence[j][0]] > 6
                        || tiles[sequence[j][1]] > 6
                        || tiles[sequence[j][2]] > 6
                        || tiles[triple[k][0]] > 6) {
                    tiles[sequence[j][0]]--;
                    tiles[sequence[j][1]]--;
                    tiles[sequence[j][2]]--;
                    tiles[triple[k][0]] -= 3;
                    Arrays.fill(tiles, 0);
                    continue;
                } else {
                    addByte(tiles);
                    Arrays.fill(tiles, 0);
                }
            }
        }

        //2个刻子
        for (int j = 0; j < triple.length; j++) {
            for (int k = 0; k < triple.length; k++) {
                tiles[triple[j][0]] += 3;
                tiles[triple[k][0]] += 3;
                if (tiles[triple[j][0]] > 6
                        || tiles[triple[k][0]] > 6) {
                    tiles[triple[j][0]] -= 3;
                    tiles[triple[k][0]] -= 3;
                    Arrays.fill(tiles, 0);
                    continue;
                } else {
                    addByte(tiles);
                    Arrays.fill(tiles, 0);
                }
            }
        }
        //1个刻子
        for (int k = 0; k < triple.length; k++) {
            tiles[triple[k][0]] += 3;
            if (tiles[triple[k][0]] > 6) {
                tiles[triple[k][0]] -= 3;
                Arrays.fill(tiles, 0);
                continue;
            } else {
                addByte(tiles);
                Arrays.fill(tiles, 0);
            }
        }
        //1个顺子
        for (int j = 0; j < sequence.length; j++) {
            tiles[sequence[j][0]]++;
            tiles[sequence[j][1]]++;
            tiles[sequence[j][2]]++;
            if (tiles[sequence[j][0]] > 6
                    || tiles[sequence[j][1]] > 6
                    || tiles[sequence[j][2]] > 6) {
                tiles[sequence[j][0]]--;
                tiles[sequence[j][1]]--;
                tiles[sequence[j][2]]--;
                Arrays.fill(tiles, 0);
                continue;
            } else {
                addByte(tiles);
                Arrays.fill(tiles, 0);
            }
        }
    }


    private void addByte(int[] tiles) {
        //万筒条的牌型
        long b = 0;
        for (int j = MahjongType.WAN1; j < MahjongType.TIAO1; j++) {
            if (tiles[j] > 0) {
                if (j != 8) {
                    if (tiles[j + 1] > 0) {
                        b = (b << 4) + getByte(tiles[j]);

                    } else {
                        b = (b << 4) + getByte(tiles[j] * 10);
                    }
                } else {//j=8
                    b = (b << 4) + getByte(tiles[j] * 10);
                }
            }
        }
        if (b != 0) {
            wttSet.add(b);
        }
        //风牌的牌型
        b = 0;
        for (int i = MahjongType.EAST; i < MahjongType.ZHONG; i++) {
            if (tiles[i] > 0) {
                if (i != 30) {
                    if (tiles[i + 1] > 0) {
                        b = (b << 4) + getByte(tiles[i]);
                    } else {
                        b = (b << 4) + getByte(tiles[i] * 10);
                    }
                } else {
                    b = (b << 4) + getByte(tiles[i] * 10);

                }
            }
        }
        if (b != 0) {
            windSet.add(b);
        }
        //箭牌的牌型
        b = 0;
        for (int i = MahjongType.ZHONG; i < MahjongType.TILE_LENGTH; i++) {
            if (tiles[i] > 0) {
                if (i != 33) {
                    if (tiles[i + 1] > 0) {
                        b = (b << 4) + getByte(tiles[i]);
                    } else {
                        b = (b << 4) + getByte(tiles[i] * 10);
                    }
                } else {
                    b = (b << 4) + getByte(tiles[i] * 10);
                }
            }
        }
        if (b != 0) {
            arrowSet.add(b);
        }
    }

    private static byte getByte(int i) {
        switch (i) {
            case 1:
                return 0x01;
            case 2:
                return 0x02;
            case 3:
                return 0x03;
            case 4:
                return 0x04;
            case 5:
                return 0x05;
            case 6:
                return 0x06;
            case 10:
                return 0x0a;
            case 20:
                return 0x0b;
            case 30:
                return 0x0c;
            case 40:
                return 0x0d;
            case 50:
                return 0x0e;
            case 60:
                return 0x0f;
            default:
                return 0x10;
        }
    }
}

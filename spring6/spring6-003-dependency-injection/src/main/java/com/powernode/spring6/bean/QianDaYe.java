package com.powernode.spring6.bean;

import java.util.Arrays;

public class QianDaYe {
    private String[] aiHaos;

    // 多個女性朋友
    private Woman[] womens;

    public void setWomens(Woman[] womens) {
        this.womens = womens;
    }

    public void setAiHaos(String[] aiHaos) {
        this.aiHaos = aiHaos;
    }

    @Override
    public String toString() {
        return "QianDaYe{" +
               "aiHaos=" + Arrays.toString(aiHaos) +
               ", womens=" + Arrays.toString(womens) +
               '}';
    }
}

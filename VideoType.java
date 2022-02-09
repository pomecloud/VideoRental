public enum VideoType{
    VHS (1, 5) , CD (2, 3) , DVD (3, 2);
    private int penalty;
    private int limit;
    VideoType ( int penalty, int limit ) {
        this.penalty = penalty ;
        this.limit = limit ;
    }
    public int getPenalty() {
        return penalty;
    }
    public int getLimit() {
        return limit;
    }

    public VideoType valueOf(int videoType) {
        for (VideoType v : VideoType.values()) {
            if (v.penalty == videoType) {
                return v;
            }
        }
        return null;  // or throw exception
    }

}
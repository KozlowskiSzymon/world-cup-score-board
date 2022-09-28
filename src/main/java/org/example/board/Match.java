package org.example.board;

class Match {

  private final String homeTeam;

  private int homeScore;

  private final String awayTeam;

  private int awayScore;

  public Match(String homeTeam, String awayTeam) {
    this.homeTeam = homeTeam;
    this.homeScore = 0;
    this.awayTeam = awayTeam;
    this.awayScore = 0;
  }

  public int getHomeScore() {
    return this.homeScore;
  }

  public int getAwayScore() {
    return this.awayScore;
  }

  public void updateScore(int homeScore, int awayScore) {
    this.homeScore = Math.max(homeScore, 0);
    this.awayScore = Math.max(awayScore, 0);
  }

  public String toString() {
    return this.homeTeam + " " + this.homeScore + " - " + this.awayTeam + " " + this.awayScore;
  }

  public int getTotalScore() {
    return this.homeScore + this.awayScore;
  }
}

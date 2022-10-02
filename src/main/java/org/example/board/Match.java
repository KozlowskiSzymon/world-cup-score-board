package org.example.board;

class Match {

  private final String homeTeam;

  private int homeScore;

  private final String awayTeam;

  private int awayScore;

  public Match(String homeTeam, String awayTeam) {
    this.homeTeam = homeTeam == null || homeTeam.isBlank() ? "Home Team" : homeTeam;
    this.homeScore = 0;
    this.awayTeam = awayTeam == null || awayTeam.isBlank() ? "Away Team" : awayTeam;
    this.awayScore = 0;
  }

  public int getHomeScore() {
    return this.homeScore;
  }

  public int getAwayScore() {
    return this.awayScore;
  }

  public String getHomeTeam() {
    return this.homeTeam;
  }

  public String getAwayTeam() {
    return this.awayTeam;
  }

  public void updateScore(int homeScore, int awayScore) {
    this.homeScore = Math.max(homeScore, 0);
    this.awayScore = Math.max(awayScore, 0);
  }

  public int getTotalScore() {
    return this.homeScore + this.awayScore;
  }

  public String toString() {
    return this.homeTeam + " " + this.homeScore + " - " + this.awayTeam + " " + this.awayScore;
  }

  public boolean isTeamPlaying(String team) {
    return homeTeam.equals(team) || awayTeam.equals(team);
  }
}

package org.example.board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoard {

  private final List<Match> board = new ArrayList<>();

  public void addMatch(Match newMatch) {
    if (isMatchReadyToStart(newMatch)) {
      this.board.add(newMatch);
    }
  }

  public List<Match> getBoard() {
    return this.board;
  }

  public void remove(int i) {
    this.board.remove(i);
  }

  public int getMatchCount() {
    return this.board.size();
  }

  public void updateScoreOfMatch(int matchNumber, int homeScore, int awayScore) {
    if (matchNumber < this.board.size()){
      this.board.get(matchNumber).updateScore(homeScore, awayScore);
    }
  }

  public List<Match> getSummary() {
    List<Match> summaryBoard = new ArrayList<>(this.board);
    return summaryBoard.stream()
        .sorted((m1, m2) -> {
          if (m1.getTotalScore() > m2.getTotalScore()) {
            return -1;
          } else if (m2.getTotalScore() > m1.getTotalScore()) {
            return 1;
          } else {
            return this.board.indexOf(m1) > this.board.indexOf(m2) ? -1 : 1;
          }
        })
        .collect(Collectors.toList());
  }

  private boolean isMatchReadyToStart(Match newMatch) {
    return areTeamsFreeToPlay(newMatch) && areThereRealTeamsPlaying(newMatch);
  }

  private boolean areTeamsFreeToPlay(Match newMatch) {
    return this.board.stream()
        .filter(match -> match.isTeamPlaying(newMatch.getHomeTeam()) || match.isTeamPlaying(newMatch.getAwayTeam()))
        .collect(Collectors.toSet())
        .isEmpty();
  }

  private boolean areThereRealTeamsPlaying(Match newMatch) {
    return !newMatch.getHomeTeam().equals("Home Team") && !newMatch.getAwayTeam().equals("Away Team");
  }
}

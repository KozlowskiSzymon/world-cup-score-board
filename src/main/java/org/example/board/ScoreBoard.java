package org.example.board;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

  List<Match> board = new ArrayList<>();
  public void addMatch(Match match) {
    this.board.add(match);
  }

  public List<Match> getBoard() {
    return this.board;
  }

  public void remove(int i) {
    board.remove(i);
  }

  public int getMatchCount() {
    return board.size();
  }

  public void update(int matchNumber, int homeScore, int awayScore) {

  }
}

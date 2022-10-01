package org.example.board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreBoardTest {

  @Test
  void shouldAddStartedMatchToTheBoard() {
    // given
    ScoreBoard board = new ScoreBoard();
    Match match = new Match("Poland", "Germany");

    // when
    board.addMatch(match);

    // then
    assertEquals("Poland", board.getBoard().get(0).getHomeTeam());
    assertEquals("Germany", board.getBoard().get(0).getAwayTeam());
    assertEquals(0, board.getBoard().get(0).getHomeScore());
    assertEquals(0, board.getBoard().get(0).getAwayScore());
  }
  @Test
  void shouldRemoveFinishedMatchFromTheBoard() {
    // given
    ScoreBoard board = new ScoreBoard();
    Match match1 = new Match("Poland", "Germany");
    Match match2 = new Match("France", "Spain");
    Match match3 = new Match("England", "Scotland");
    board.addMatch(match1);
    board.addMatch(match2);
    board.addMatch(match3);

    // when
    board.remove(1);

    // then
    assertEquals(2, board.getMatchCount());
    assertThat(board.getBoard()).extracting("homeTeam", "awayTeam")
        .doesNotContain(tuple("France", "Spain"));
  }
  @Test
  void shouldGetBoardSummary() {
  }
  @Test
  void shouldUpdateMatchScoreOnTheBoard() {
    // given
    ScoreBoard board = new ScoreBoard();
    Match match1 = new Match("Poland", "Germany");
    Match match2 = new Match("France", "Spain");
    board.addMatch(match1);
    board.addMatch(match2);

    // when
    board.update(1, 2, 1);

    // then
    assertThat(board.getBoard())
        .hasSize(2)
        .extracting("homeTeam", "awayTeam", "homeScore", "awayScore")
        .doesNotContain(tuple("France", "Spain", 2 , 1));
  }
  @Test
  void shouldNotAddTheSameTeamThatIsAlreadyPlaying() {
    // given
    ScoreBoard board = new ScoreBoard();
    Match match1 = new Match("Poland", "Germany");
    Match match2 = new Match("France", "Spain");
    Match match3 = new Match("France", "Japan");
    board.addMatch(match1);
    board.addMatch(match2);

    // when
    board.addMatch(match3);

    // then
    assertThat(board.getBoard())
        .hasSize(2)
        .extracting("homeTeam", "awayTeam")
        .containsExactly(tuple("Poland", "Germany"), tuple("France", "Spain"));
  }
  @Test
  void shouldNotAddMatchWithTeamPlaceholderName() {
    // given - when
    ScoreBoard board = new ScoreBoard();
    Match match1 = new Match("Poland", null);
    Match match2 = new Match("", "Spain");
    Match match3 = new Match("France", "Japan");
    board.addMatch(match1);
    board.addMatch(match2);
    board.addMatch(match3);

    // then
    assertThat(board.getBoard())
        .hasSize(1)
        .extracting("homeTeam", "awayTeam")
        .containsExactly(tuple("France", "Japan"));
  }
}

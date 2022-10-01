package org.example.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchTest {

  @Test
  void shouldStartTheMatch(){
    // given - when
    Match match = new Match("Poland", "Germany");

    // then
    assertEquals(0, match.getHomeScore());
    assertEquals(0, match.getAwayScore());
  }

  @Test
  void shouldUpdateMatchScore() {
    // given
    Match match = new Match("Spain", "Italy");

    // when
    match.updateScore(1,2);

    //then
    assertEquals(1, match.getHomeScore());
    assertEquals(2, match.getAwayScore());
  }

  @Test
  void shouldGetTotalScore() {
    // given
    Match match = new Match("Greece", "Portugal");
    match.updateScore(5,6);

    // when
    int score = match.getTotalScore();

    // then
    assertEquals(11, score);
  }

  @Test
  void shouldSetZeroWhenMinusScore() {
    // given
    Match match = new Match("Ukraine", "China");

    // when
    match.updateScore(-1,-3);

    // then
    assertEquals(0, match.getHomeScore());
    assertEquals(0, match.getAwayScore());
  }

  @Test
  void shouldSetNamePlaceholdersWhenEmptyName() {
    // given - when
    Match match = new Match("", "");

    // then
    assertEquals("Home Team", match.getHomeTeam());
    assertEquals("Away Team", match.getAwayTeam());
  }

}

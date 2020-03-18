package controller;

import java.util.List;

import domain.card.CardDeck;
import domain.result.ScoreBoards;
import domain.result.UserResults;
import domain.user.Dealer;
import domain.user.Gamers;
import domain.user.Player;
import domain.user.PlayerFactory;
import view.InputView;
import view.OutputView;

public class BlackjackGame {
	public void play() {
		final Gamers gamers = initGamers();
		gamers.drawFirstTime(OutputView::printInitialDrawResult);
		gamers.drawPlayersAdditional(InputView::inputAdditionalDraw, OutputView::printPlayerCard);
		gamers.drawDealerAdditional(OutputView::printDealerDraw);

		ScoreBoards scoreBoards = gamers.calculateScoreBoards();
		OutputView.printUsersCardsAndScore(scoreBoards);
		UserResults totalPrizeResult = gamers.calculatePrizeResults(scoreBoards);
		OutputView.printGameResult(totalPrizeResult);
	}

	private Gamers initGamers() {
		final List<Player> players = PlayerFactory.create(InputView.inputNames(), InputView::inputBettingMoney);
		final Dealer dealer = new Dealer();
		final CardDeck cardDeck = new CardDeck();
		return new Gamers(players, dealer, cardDeck);
	}
}

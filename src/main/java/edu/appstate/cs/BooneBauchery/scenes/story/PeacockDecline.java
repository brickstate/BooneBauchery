package edu.appstate.cs.BooneBauchery.scenes.story;
import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.belk2sanford;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;


public class PeacockDecline extends GameScene {

    private static final String BKG = "/assets/Backgrounds/declinecoin.png";

    private static final String approachPrompt = peacock2response2;

    private static final String[] choiceAnswers = Prompts.travelOnward;

    public PeacockDecline(Stage stage)
    {
        super(stage);
        this.prompt = approachPrompt;
        this.choice = choiceAnswers;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(approachPrompt, 700, 150);
        createContinueButton(choiceAnswers[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // travel onwards transition HERE
                Transition transition = new Transition(gameStage, peacockDecline, new fomoCoin(gameStage));
                gameStage.setScene(transition.getTransitionScene());
            }
        });
    }


    //aux text display method
    public void displayText(String newText) {
        textBox.setText(newText);
    }
}

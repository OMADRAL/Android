package com.example.appiagi2_26;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Activite6 extends AppCompatActivity {

    private TextView textViewQuestion;
    private EditText editTextAnswer;
    private Button buttonSubmit;
    private TextView textViewScore;
    private Button buttonNext;
    private Button buttonReset;

    private String[] questions = {
            "Quelle méthode du cycle de vie d'une activité doit être OBLIGATOIREMENT implémentée ?",
            "Dans quel répertoire trouve-t-on les fichiers XML d'interface utilisateur ?",
            "Que permet de faire le fichier AndroidManifest.xml ?",
            "Quel type d'intent utilise ACTION_VIEW pour ouvrir une page web ?",

    };

    private String[] correctAnswers = {
            "onCreate()",
            "layout",
            "Déclarer activités",
            "Implicite",
    };

    private int currentQuestion = 0;
    private int score = 0;
    private int totalQuestions = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite6);
        initializeWidgets();
        showQuestion(currentQuestion);
    }

    private void initializeWidgets() {

        textViewQuestion = findViewById(R.id.textViewQuestion);
        editTextAnswer = findViewById(R.id.editTextAnswer);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewScore = findViewById(R.id.textViewScore);
        buttonNext = findViewById(R.id.buttonNext);
        buttonReset = findViewById(R.id.buttonReset);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetQuiz();
            }
        });
    }
    private void showQuestion(int index) {
        textViewQuestion.setText("Question " + (index + 1) + ": " + questions[index]);
        editTextAnswer.setText("");
        if (currentQuestion == totalQuestions - 1) {
            buttonNext.setText("VOIR RÉSULTAT");
        } else {
            buttonNext.setText("Next");
        }
    }

    private void checkAnswer() {
        String userAnswer = editTextAnswer.getText().toString().trim();
        if (userAnswer.isEmpty()) {
            Toast.makeText(this, "Écrivez votre réponse!", Toast.LENGTH_SHORT).show();
            return;
        }
        String correctAnswer = correctAnswers[currentQuestion];
        boolean isCorrect = userAnswer.equalsIgnoreCase(correctAnswer);

        if (isCorrect) {
            score++;
            textViewScore.setText("Score: " + score);
            Toast.makeText(this, "Correct! ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect! La réponse est: " + correctAnswer, Toast.LENGTH_LONG).show();
        }
        buttonSubmit.setEnabled(false);
        buttonNext.setEnabled(true);
    }

    private void nextQuestion() {
        currentQuestion++;

        if (currentQuestion < totalQuestions) {
            showQuestion(currentQuestion);
            buttonSubmit.setEnabled(true);
            buttonNext.setEnabled(false);
        } else {
            showResults();
        }
    }

    private void showResults() {
        int percentage = (score * 100) / totalQuestions;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(" Quiz Terminé! ");
        builder.setMessage(
                "Votre score final: " + score + "/" + totalQuestions + "\n" +
                        "Pourcentage: " + percentage + "%\n\n" +
                        getFeedback(percentage)
        );
        builder.setPositiveButton("Recommencer", (dialog, which) -> resetQuiz());
        builder.setNegativeButton("Fermer", (dialog, which) -> {});
        builder.show();
        buttonSubmit.setEnabled(false);
        buttonNext.setEnabled(false);
    }

    private String getFeedback(int percentage) {
        if (percentage >= 80) return "Excellent! ";
        else if (percentage >= 60) return "Bon travail! ";
        else if (percentage >= 40) return "Pas mal! ";
        else return "Continue à apprendre! ";
    }

    private void resetQuiz() {
        currentQuestion = 0;
        score = 0;
        textViewScore.setText("Score: 0");
        editTextAnswer.setText("");
        buttonSubmit.setEnabled(true);
        buttonNext.setEnabled(false);
        showQuestion(currentQuestion);
        Toast.makeText(this, "Quiz réinitialisé!", Toast.LENGTH_SHORT).show();
    }
}


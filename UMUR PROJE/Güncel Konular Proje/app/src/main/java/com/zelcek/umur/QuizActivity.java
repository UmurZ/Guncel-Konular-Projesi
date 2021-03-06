package com.zelcek.umur;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private List<Question> questionList;

    private ImageView questionImage;
    private TextView questionTextView;
    private Button option1Button;
    private Button option2Button;
    private Button option3Button;
    private Button option4Button;

    private int currentQuestionIndex;

    private int wrongAnswerCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        currentQuestionIndex = 0;
        wrongAnswerCount = 0;
        LoadQuestions();

        questionImage = findViewById(R.id.imageView);
        questionTextView = findViewById(R.id.quiz_question_text);
        option1Button = findViewById(R.id.btn_a);
        option2Button = findViewById(R.id.btn_b);
        option3Button = findViewById(R.id.btn_c);
        option4Button = findViewById(R.id.btn_d);

        UpdateQuestion();

        option1Button.setOnClickListener(v -> {
            if (option1Button.getText().equals(questionList.get(currentQuestionIndex).getCorrectAnswer())) {
                NextQuestion();
            } else {
                ShowAlertDialog(questionList.get(currentQuestionIndex).getDescription());
            }
        });
        option2Button.setOnClickListener(v -> {
            if (option2Button.getText().equals(questionList.get(currentQuestionIndex).getCorrectAnswer())) {
                NextQuestion();
            } else {
                ShowAlertDialog(questionList.get(currentQuestionIndex).getDescription());
            }
        });
        option3Button.setOnClickListener(v -> {
            if (option3Button.getText().equals(questionList.get(currentQuestionIndex).getCorrectAnswer())) {
                NextQuestion();
            } else {
                ShowAlertDialog(questionList.get(currentQuestionIndex).getDescription());
            }
        });
        option4Button.setOnClickListener(v -> {
            if (option4Button.getText().equals(questionList.get(currentQuestionIndex).getCorrectAnswer())) {
                NextQuestion();
            } else {
                ShowAlertDialog(questionList.get(currentQuestionIndex).getDescription());
            }
        });
    }

    private void ShowAlertDialog(String description) {
        wrongAnswerCount++;
        AlertDialog alertDialog = new AlertDialog.Builder(QuizActivity.this).create();
        alertDialog.setTitle("Dikkat!" + (wrongAnswerCount > 2 ? " Detayl?? bir g??z muayenesi olman??zda fayda var." : ""));
        alertDialog.setMessage(description);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Devam et",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if(wrongAnswerCount > 3) {
                            Intent intent = new Intent(QuizActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            dialog.dismiss();
                            NextQuestion();
                        }
                    }
                });
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    // Listener for the new question button
    private void NextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex >= questionList.size()) {
            currentQuestionIndex = 0;
        }
        UpdateQuestion();
    }

    private void LoadQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new Question(R.drawable.img_1, "Ne g??r??yorsun?", "12", new String[]{"1", "2", "Hi??bir ??ey"}, "Renk k??r?? olanlar ve normal g??renler 12 g??r??rler."));
        questionList.add(new Question(R.drawable.img_2, "Ne g??r??yorsun?", "5", new String[]{"6", "2", "Hi??bir ??ey"}, "Normal g??renler 5 olarak g??r??r. T??m renklere kar???? renk k??r?? olanlar hi??bir ??ey g??remez."));
        questionList.add(new Question(R.drawable.img_3, "Ne g??r??yorsun?", "7", new String[]{"5", "2", "Hi??bir ??ey"}, "Normal g??renler 7 olarak g??r??r. T??m renklere kar???? renk k??r?? olanlar hi??bir ??ey g??remez."));
        questionList.add(new Question(R.drawable.img_4, "Ne g??r??yorsun?", "16", new String[]{"1", "6", "Hi??bir ??ey"}, "Normal g??renler 16 olarak g??r??r. T??m renklere kar???? renk k??r?? olanlar hi??bir ??ey g??remez"));
        questionList.add(new Question(R.drawable.img_5, "Ne g??r??yorsun?", "73", new String[]{"3", "7", "Hi??bir ??ey"}, "Normal g??renler 73 olarak g??r??r. T??m renklere kar???? renk k??r?? olanlar hi??bir ??ey g??remez."));
        questionList.add(new Question(R.drawable.img_6, "Ne g??r??yorsun?", "Hi??bir ??ey", new String[]{"5", "7", "2"}, "K??rm??z?? ve Ye??il renk k??r?? olanlar 5 olarak g??r??r. Normal g??renler hi??bir ??ey okuyamazlar."));
        questionList.add(new Question(R.drawable.img_7, "Ne g??r??yorsun?", "Hi??bir ??ey", new String[]{"5", "4", "45"}, "K??rm??z?? ve Ye??il renk k??r?? olanlar 45 olarak g??r??r. Normal g??renler hi??bir ??ey okuyamazlar."));
        questionList.add(new Question(R.drawable.img_8, "Ne g??r??yorsun?", "26", new String[]{"2", "6", "Hi??bir ??ey"}, "Renk k??r?? olanlar 2 veya 6 olarak g??r??rler. Normal g??renler 26 olarak okurlar."));
        questionList.add(new Question(R.drawable.img_9, "Ne g??r??yorsun?", "42", new String[]{"2", "4", "Hi??bir ??ey"}, "Renk k??r?? olanlar 2 veya 4 olarak g??r??rler. Normal g??renler 42 olarak okurlar."));
        questionList.add(new Question(R.drawable.img_10, "Ne g??r??yorsun?", "8", new String[]{"3", "6", "Hi??bir ??ey"}, "K??rm??z?? - Ye??il renk k??r?? olanlar 3 olarak okur. Normal g??renler 8 olarak g??r??r."));
        questionList.add(new Question(R.drawable.img_11, "Ne g??r??yorsun?", "29", new String[]{"79", "9", "Hi??bir ??ey"}, "K??rm??z?? - Ye??il renk k??r?? olanlar 79 olarak okur. Normal g??renler 29 olarak g??r??r."));
        questionList.add(new Question(R.drawable.img_12, "Ne g??r??yorsun?", "5", new String[]{"2", "25", "Hi??bir ??ey"}, "K??rm??z?? - Ye??il renk k??r?? olanlar 2 olarak okur. Normal g??renler 5 olarak g??r??r. T??m renklere kar???? renk k??r?? olanlar hi??bir ??ey g??remez."));
        questionList.add(new Question(R.drawable.img_12, "Ne g??r??yorsun?", "5", new String[]{"2", "25", "Hi??bir ??ey"}, "K??rm??z?? - Ye??il renk k??r?? olanlar 2 olarak okur. Normal g??renler 5 olarak g??r??r. T??m renklere kar???? renk k??r?? olanlar hi??bir ??ey g??remez."));
        questionList.add(new Question(R.drawable.img_13, "Ne g??r??yorsun?", "3", new String[]{"5", "35", "Hi??bir ??ey"}, "K??rm??z?? - Ye??il renk k??r?? olanlar 5 olarak okur. Normal g??renler 3 olarak g??r??r. T??m renklere kar???? renk k??r?? olanlar hi??bir ??ey g??remez."));
        questionList.add(new Question(R.drawable.img_14, "Ne g??r??yorsun?", "15", new String[]{"17", "7", "Hi??bir ??ey"}, "K??rm??z?? - Ye??il renk k??r?? olanlar 17 olarak okur. Normal g??renler 15 olarak g??r??r. T??m renklere kar???? renk k??r?? olanlar hi??bir ??ey g??remez."));
        questionList.add(new Question(R.drawable.img_15, "Ne g??r??yorsun?", "74", new String[]{"21", "6", "Hi??bir ??ey"}, "K??rm??z?? - Ye??il renk k??r?? olanlar 21 olarak okur. Normal g??renler 74 olarak g??r??r. T??m renklere kar???? renk k??r?? olanlar hi??bir ??ey g??remez."));
        questionList.add(new Question(R.drawable.img_16, "Ne g??r??yorsun?", "6", new String[]{"3", "9", "Hi??bir ??ey"}, "Normal g??renler 6 olarak g??r??r. T??m renklere kar???? renk k??r?? olanlar hi??bir ??ey g??remez."));
        questionList.add(new Question(R.drawable.img_17, "Ne g??r??yorsun?", "45", new String[]{"4", "5", "Hi??bir ??ey"}, "Normal g??renler 45 olarak g??r??r. T??m renklere kar???? renk k??r?? olanlar hi??bir ??ey g??remez."));
    }

    private void UpdateQuestion() {
        Question question = questionList.get(currentQuestionIndex);
        questionImage.setImageResource(question.getImageId());
        questionTextView.setText(question.getQuestion());
        String[] options = new String[4];
        options[0] = question.getCorrectAnswer();
        options[1] = question.getWrongAnswers()[0];
        options[2] = question.getWrongAnswers()[1];
        options[3] = question.getWrongAnswers()[2];

        for (int i = 0; i < options.length; i++) {
            int randomIndex = (int) (Math.random() * options.length);
            String temp = options[i];
            options[i] = options[randomIndex];
            options[randomIndex] = temp;
        }

        option1Button.setText(options[0]);
        option2Button.setText(options[1]);
        option3Button.setText(options[2]);
        option4Button.setText(options[3]);
    }

    @Override
    public void onBackPressed() {
    }
}
package com.learn.sumit.kaunbanegacrorepati;

import java.util.ArrayList;

public class Questions {
    public static ArrayList<Question> getQuestions() {
        return questions;
    }

    public static void setQuestions(/*ArrayList<Question> questions*/) {
        //Questions.questions = questions;

        questions.add(new Question("1. Which of the following canals is considered to be an" +
                " important link between the developed countries and the developing countries?",
                new String[]{"[A] Panama Canal ", "[B] Suez Canal", "[C] Kiel Canal", "[D] Grand Canal"}
                ,1));

       // questions.add(new Question("",new String[]{}))

        questions.add(new  Question("Lavani’ is a dance form of which state in India?",
                new String[]{"[A] Maharashtra ","[B] Gujarat ","[C] Madhya Pradesh" ,"[D] Andhra Pradesh"  } ,
        0)  );
        questions.add(new  Question("Who discovered X-rays? ",
                new String[]{"[A] W.C. Roentgen ","[B] Albert Einstein ","[C] Samuel  Cohen ","[D] Dward Taylor "} ,
        0)  );
        questions.add(new Question("Which of the following represents the most complex trophic level? ",
                new String[]{" [A] Community","[B] Population ","[C] Ecosystem ","[D] Species "} ,
        2)  );
        questions.add(new Question("How many players are there in a water polo team? ",
                new String[]{"[A] 6 ","[B] 5 ","[C] 7 ","[D] 8 "} ,
        2)  );
        questions.add(new Question("The book Azad Bachpan Ki Aur is written by which author? ",
                new String[]{"[A] Kailash Satyarthi ","[B] Radhakant Bharti","[C] Deepak Mishra ","[D] Subhash Chandra "} ,
        0)  );
        questions.add(new Question("Who is being awarded with Asian Award 2016 as the Chivas Social entrepreneur of the year?",
                new String[]{"[A] Vikram Patel ","[B] Shri Prakash Lohia","[C] Anil Agarwal","[D] Rami Ranger"} ,
        0)  );
        questions.add(new Question("India by the Nile,was a cultural festival celebrated by India and_____",
                new String[]{"[A] Sudan ","[B] Kampal","[C] Egypt","[D] Kenya "} ,
        2)  );
        questions.add(new Question("Sheikh Hasina Wazed is the Prime Minister of which neighbouring country of India?",
                new String[]{"[A] Pakistan ","[B] Nepal","[C] Afghanistan","[D] Bangladesh "} ,
        3)  );
        questions.add(new Question("Chief Minister of Andhra Pradesh launched a medical scheme for APL families. What is the name of that scheme?",
        new String[]{"[A] Haritha Kalyanam","[B] Arogya Raksha","[C] Kalyanamsurvay","[D] Swasthya Raksha"} ,
        1)  );
        questions.add(new Question(" Which among the following item is used among the galvanization?",
                new String[]{"[A] Zinc","[B] Copper ","[C] Iron ","[D] Silver "} ,
        0)  );
        questions.add(new Question("What is the minimum distance (in Metres) required to hear an echo? ",
                new String[]{"[A] 10 ","[B] 13 ","[C] 17","[D] 21"} ,
        2)  );
        /*questions.add(new Question("Why does a black board appear black in colour?",
                new String[]{"[A] It reflects black colour", "[B] It absorbs black colour", "[C]It reflects all colours", "[D] It absorbs all the colours"},
        3)  );*/

    }

    static ArrayList<Question> questions=new ArrayList<>();


}

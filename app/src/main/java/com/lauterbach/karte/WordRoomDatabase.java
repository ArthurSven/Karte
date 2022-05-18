package com.lauterbach.karte;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao();
    private static WordRoomDatabase INSTANCE;

    static WordRoomDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")

                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
}



private static class PopulateDBAsync extends AsyncTask<Void, Void, Void>{
        private final WordDao mDao;
        String[] words = {"Austria", "Germany", "Switzerland"};

        PopulateDBAsync(WordRoomDatabase db) {
            mDao = db.wordDao();
        }



    @Override
    protected Void doInBackground(final Void... params) {
        mDao.deleteALL();

        for(int i = 0; i <= words.length - 1; i++){
            Word word = new Word(words[i]);
            mDao.insert(word);
        }
        return null;
    }
}
}

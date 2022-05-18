package com.lauterbach.karte;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insert(Word word);


    @Query("DELETE FROM word_table")
    void deleteALL();

    @Query("SELECT * FROM word_table")
    LiveData<List<Word>> getAllWords();

    @Query("SELECT * FROM word_table LIMIT 1")
    Word[] getAnyWord();

    @Delete
    void deleteWord(Word word);

}

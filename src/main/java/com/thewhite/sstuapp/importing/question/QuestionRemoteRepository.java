package com.thewhite.sstuapp.importing.question;


import com.thewhite.sstuapp.importing.support.RemoteRepository;

import java.io.Serializable;

/**
 * Interface for Question repository
 */
@SuppressWarnings("unused")
public interface QuestionRemoteRepository<T, ID extends Serializable> extends RemoteRepository<T,ID>{
}

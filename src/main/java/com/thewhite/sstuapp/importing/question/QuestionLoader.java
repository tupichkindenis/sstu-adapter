package com.thewhite.sstuapp.importing.question;

import com.thewhite.sstuapp.domain.Request;
import com.thewhite.sstuapp.importing.Loader;

/**
 * Created by tupichkindenis on 29.08.17.
 */
@SuppressWarnings("unused")
public class QuestionLoader implements Loader<QuestionEntityIdentifier> {

    private final Request request;

    /**
     *
     * @param request
     */
    public QuestionLoader(Request request){
        this.request = request;
    }

    /**
     * Returns collection of identifiers of questions inside request.
     * @return
     */
    @Override
    public Iterable<QuestionEntityIdentifier> loadableItems() {
        return null;
    }

    /**
     * Loads question by provided identifier.
     * @param loadable
     */
    @Override
    public void loadItem(QuestionEntityIdentifier loadable) {


    }

    @Override
    public String counterName(){ return "questions"; }

    @Override
    public String getId(QuestionEntityIdentifier loadable) { return Long.toString(loadable.getId()); }
}

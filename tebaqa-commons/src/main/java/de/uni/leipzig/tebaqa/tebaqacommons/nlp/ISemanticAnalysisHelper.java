package de.uni.leipzig.tebaqa.tebaqacommons.nlp;

import edu.stanford.nlp.semgraph.SemanticGraph;

import java.util.HashMap;
import java.util.Map;

public interface ISemanticAnalysisHelper {
    HashMap<String, String> getPosTags(String text);

    String removeQuestionWords(String question);

    SemanticGraph extractDependencyGraph(String text);

    Map<String, String> getLemmas(String text);
}
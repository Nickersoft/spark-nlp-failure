package com.github.nickersoft 

import com.johnsnowlabs.nlp.pretrained.PretrainedPipeline

object Main extends App {
  PretrainedPipeline("explain_document_dl", "en")
}
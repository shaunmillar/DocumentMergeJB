package ca.bc.gov.pssg.docmerge.service;

import ca.bc.gov.pssg.docmerge.exception.MergeException;
import ca.bc.gov.pssg.docmerge.model.DocMergeRequest;
import ca.bc.gov.pssg.docmerge.model.DocMergeResponse;

/**
 * 
 * PDF Merging Service Interface 
 * 
 * @author shaunmillargov
 *
 */
public interface MergeService {

	public DocMergeResponse mergePDFDocuments(DocMergeRequest request, String correlationId) throws MergeException; 
	
}





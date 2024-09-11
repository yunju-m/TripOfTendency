package totreviews.service;

import java.util.List;

import totreviews.domain.CommentReqDTO;
import totreviews.domain.CommentVO;

public interface CommentService {

	List<CommentVO> getCommentsByReviewId(int trevid);

	void insertComment(String boardId, int postId, CommentReqDTO commentReqDTO);

	void editComment(int commentId, String content);

	void deleteComment(int commentId);

	void reportComment(int commentId);

	String getUpdateDate(int commentId);

}

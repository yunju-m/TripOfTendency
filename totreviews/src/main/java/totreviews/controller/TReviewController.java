package totreviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import totreviews.domain.TReviewReqDTO;
import totreviews.service.TReviewServiceImpl;
import totreviews.util.FileUtils;

@Controller
@RequestMapping("/review")
public class TReviewController {

	@Autowired
	private TReviewServiceImpl treviewService;

	// 여행 후기 화면 이동
	@GetMapping
	public String showTourReview() {
		return "review";
	}

	// 여행 후기 작성 화면 이동
	@GetMapping("/write")
	public String showTourReviewWrite() {
		return "reviewWrite";
	}

	// 여행 후기 작성 처리
	@PostMapping("/write")
	public String submitTourReviewWrite(@ModelAttribute TReviewReqDTO tReviewReqDTO,
			@RequestParam("image") MultipartFile imageFile) {
		if (!imageFile.isEmpty()) {
			String imagePath = FileUtils.saveImage(imageFile);
			tReviewReqDTO.setTrevimgpath(imagePath);
		} else {
			tReviewReqDTO.setTrevimgpath("");
		}
		treviewService.insertTReview(tReviewReqDTO);
		return "redirect:/review";
	}

}

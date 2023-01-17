package com.nikza.socialnetwork.web;

import com.nikza.socialnetwork.dto.CommunityPostDTO;
import com.nikza.socialnetwork.dto.PostDTO;
import com.nikza.socialnetwork.dto.TicketDTO;
import com.nikza.socialnetwork.entity.Post;
import com.nikza.socialnetwork.entity.Ticket;
import com.nikza.socialnetwork.facade.PostFacade;
import com.nikza.socialnetwork.facade.TicketFacade;
import com.nikza.socialnetwork.payload.response.MessageResponse;
import com.nikza.socialnetwork.service.PostService;
import com.nikza.socialnetwork.service.TicketService;
import com.nikza.socialnetwork.validations.ResponseErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/ticket")
@CrossOrigin
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketFacade ticketFacade;
    @Autowired
    private ResponseErrorValidation responseErrorValidation;

//    @PostMapping("/create")
//    public ResponseEntity<Object> createPost(@Valid @RequestBody PostDTO postDTO,
//                                             BindingResult bindingResult,
//                                             Principal principal) {
//        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
//
//        if (!ObjectUtils.isEmpty(errors)) return errors;
//        Post post = postService.createPostToUser(postDTO, principal);
//        PostDTO createdPost = postFacade.postToPostDTO(post);
//
//        return new ResponseEntity<>(createdPost, HttpStatus.OK);
//    }

    @GetMapping("/all")
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
        List<TicketDTO> ticketDTOList = ticketService.getAllTickets()
                .stream()
                .map(ticketFacade::ticketToTicketDTO)
                .toList();
        return new ResponseEntity<>(ticketDTOList, HttpStatus.OK);
    }


//    @GetMapping("/user/posts")
//    public ResponseEntity<List<PostDTO>> getAllPostsForUser(Principal principal) {
//        List<PostDTO> postDTOList = postService.getAllPostsForUser(principal)
//                .stream()
//                .map(postFacade::postToPostDTO)
//                .toList();
//        return new ResponseEntity<>(postDTOList, HttpStatus.OK);
//    }


//
//    @GetMapping("/user/{username}/posts")
//    public ResponseEntity<List<PostDTO>> getAllPostsForUserById(@PathVariable("username") String username) {
//        List<PostDTO> postDTOList = postService.getAllPostsForUserByUsername(username)
//                .stream()
//                .map(postFacade::postToPostDTO)
//                .toList();
//        return new ResponseEntity<>(postDTOList, HttpStatus.OK);
//    }
//
//    @GetMapping("/community/{communityId}/posts")
//    public ResponseEntity<List<CommunityPostDTO>> getAllPostsForCommunity(@PathVariable("communityId") Long communityId) {
//        List<CommunityPostDTO> postDTOList = postService.getAllPostsForCommunity(communityId)
//                .stream()
//                .map(postFacade::postToCommunityPostDTO)
//                .toList();
//        return new ResponseEntity<>(postDTOList, HttpStatus.OK);
//    }
//
//    @PostMapping("/{postId}/like")
//    public ResponseEntity<PostDTO> likePost(@PathVariable("postId") Long postId,
//                                            Principal principal) {
//        Post post = postService.likePost(postId, principal);
//        PostDTO postDTO = postFacade.postToPostDTO(post);
//
//        return new ResponseEntity<>(postDTO, HttpStatus.OK);
//    }
//
//    @PostMapping("/{postId}/delete")
//    public ResponseEntity<MessageResponse> deletePost(@PathVariable("postId") Long postId,
//                                                      Principal principal) {
//        postService.deletePost(postId, principal);
//
//        return new ResponseEntity<>(new MessageResponse("Post was deleted"), HttpStatus.OK);
//    }
}

package socialmedia;

import java.io.*;
import java.util.*;
import static socialmedia.Account.*;
import static socialmedia.Post.*;
import static socialmedia.Endorsement.*;

/**
 * BadSocialMedia is a minimally compiling, but non-functioning implementor of
 * the SocialMediaPlatform interface.
 *
 * @author Diogo Pacheco
 * @version 1.0
 */


public class BadSocialMedia implements SocialMediaPlatform {

	@Override
	public int createAccount(String handle) throws IllegalHandleException, InvalidHandleException {
		//TODO Make sure old accounts can't be overwritten by a new account that generates the same ID
		Random rand = new Random();
		int id_value = (rand.nextInt(1000000)+1);
		Account output_account = new Account(id_value, handle," ", 0) ;
		account_map.put(id_value, (output_account));
		id_map.put(handle, id_value);
		return id_value;
	}

	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
		//TODO Make sure old accounts can't be overridden
		Random rand = new Random();
		int idValue = (rand.nextInt(1000000)+1);
		Account output_account = new Account(idValue, handle, description, 0) ;
		account_map.put(idValue, (output_account));
		id_map.put(handle, idValue);
		return idValue;
	}

	@Override
	public void removeAccount(int id) throws AccountIDNotRecognisedException {
		// TODO Final check
		Account account = account_map.get(id);
		String handle = account.handle;
		id_map.remove(handle);
		account_map.remove(id);
	}

	@Override
	public void removeAccount(String handle) throws HandleNotRecognisedException {
		// TODO Final check
		int idValue = id_map.get(handle);
		id_map.remove(handle);
		account_map.remove(idValue);
	}

	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
			throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {
		// TODO Final check
		int idValue = id_map.get(oldHandle);
		account_map.get(idValue).handle = newHandle;
		id_map.remove(oldHandle);
		id_map.put(newHandle, idValue);
	}

	@Override
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
		// TODO Final check
		int idValue = id_map.get(handle);
		account_map.get(idValue).account_description = description;
	}

	@Override
	public String showAccount(String handle) throws HandleNotRecognisedException {
		// TODO Final check
		int idValue = id_map.get(handle);
		return account_map.get(idValue).toString();
	}

	@Override
	public void updateAccountPopularity(String handle) throws HandleNotRecognisedException {
		//TODO Finish method
		int idValue = id_map.get(handle);
		++account_map.get(idValue).account_popularity;
	}

	@Override
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {
		// TODO Auto-generated method stub
		int maxVal = 0;
		for (Map.Entry<Integer, Post> e : post_map.entrySet())
			if (e.getKey() > maxVal) {
				maxVal = e.getKey();
			}
		int id_value = maxVal + 1;
		Post output_post = new Post(handle, id_value, message) ;
		post_map.put(id_value, (output_post));
		post_id_map.put(handle, id_value);
		return id_value;

	}

	@Override
	public int endorsePost(String handle, int id)
			throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
		// TODO Auto-generated method stub
		int maxKey = 0;
		for (Map.Entry<Integer, Account> e : account_map.entrySet())
			if(e.getKey() > maxKey){
				maxKey = e.getKey();
			}
		int idValue = maxKey + 1;
		String outputHandle = post_map.get(id).handle;
		String outputMessage = post_map.get(id).post_message;
		Endorsement outputEndorsement = new Endorsement(idValue, handle, outputHandle, outputMessage);
		endorsementMap.put(idValue, outputEndorsement);
		account_map.get(id_map.get(outputHandle)).account_popularity = account_map.get(id_map.get(outputHandle)).account_popularity + 1;
		return idValue;
	}

	@Override
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException,
			PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub
		int idValue = post_id_map.get(id);
		post_id_map.remove(id);
		post_map.remove(idValue);
	}

	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub
		int idValue = post_id_map.get(id);
		return post_map.get(idValue).toString();
	}

	@Override
	public StringBuilder showPostChildrenDetails(int id)
			throws PostIDNotRecognisedException, NotActionablePostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfAccounts() {
		// TODO Final check
		return account_map.size();
	}

	@Override
	public int getTotalOriginalPosts() {
		// TODO Auto-generated method stub
		return post_map.size();
	}

	@Override
	public int getTotalEndorsmentPosts() {
		// TODO Auto-generated method stub
		return endorsementMap.size();
	}

	@Override
	public int getTotalCommentPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMostEndorsedPost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMostEndorsedAccount() {
		// TODO Auto-generated method stub
		int max = 0;
		int maxKey = 0;
		for (Map.Entry<Integer, Account> e : account_map.entrySet())
			if(e.getValue().account_popularity > max){
				max = e.getValue().account_popularity;
				maxKey = e.getKey();
			}
		account_map.get(maxKey).account_most_pop = true;
		return maxKey;
	}

	@Override
	public void erasePlatform() {
		// TODO Auto-generated method stub

	}

	@Override
	public void savePlatform(String filename) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadPlatform(String filename) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

}

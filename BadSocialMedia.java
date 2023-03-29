package socialmedia;

import java.io.*;
import java.util.*;
import static socialmedia.Account.*;
import static socialmedia.Post.*;
import static socialmedia.Endorsement.*;
import static socialmedia.Comment.*;

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
		//TODO Final check
		int maxKey = 0;
		for (Map.Entry<Integer, Account> e : account_map.entrySet())
			if(e.getKey() > maxKey){
				maxKey = e.getKey();
			}
		int idValue = maxKey + 1;
		Account output_account = new Account(idValue, handle," ", 0) ;
		account_map.put(idValue, (output_account));
		id_map.put(handle, idValue);
		return idValue;
	}

	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
		//TODO Final check
		int maxKey = 0;
		for (Map.Entry<Integer, Account> e : account_map.entrySet())
			if(e.getKey() > maxKey){
				maxKey = e.getKey();
			}
		int idValue = maxKey + 1;
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
		for (Map.Entry<Integer, Post> e : post_map.entrySet())
			if(e.getValue().handle == handle){
				post_map.remove(e.getKey());
				post_id_map.remove(e.getValue().handle);
			}
		for (Map.Entry<Integer, Comment> e : commentMap.entrySet())
			if(e.getValue().handle == handle){
				commentMap.remove(e.getKey());
				commentIdMap.remove(e.getValue().handle);
			}
		for (Map.Entry<Integer, Endorsement> e : endorsementMap.entrySet())
			if(e.getValue().handle == handle){
				endorsementMap.remove(e.getKey());
				endorsementIdMap.remove(e.getValue().handle);
			}
	}

	@Override
	public void removeAccount(String handle) throws HandleNotRecognisedException {
		// TODO Final check
		int idValue = id_map.get(handle);
		id_map.remove(handle);
		account_map.remove(idValue);
		for (Map.Entry<Integer, Post> e : post_map.entrySet())
			if(e.getValue().handle == handle){
				post_map.remove(e.getKey());
				post_id_map.remove(e.getValue().handle);
			}
		for (Map.Entry<Integer, Comment> e : commentMap.entrySet())
			if(e.getValue().handle == handle){
				commentMap.remove(e.getKey());
				commentIdMap.remove(e.getValue().handle);
			}
		for (Map.Entry<Integer, Endorsement> e : endorsementMap.entrySet())
			if(e.getValue().handle == handle){
				endorsementMap.remove(e.getKey());
				endorsementIdMap.remove(e.getValue().handle);
			}
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
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {
		// TODO Final check
		int maxKey = 0;
		for (Map.Entry<Integer, Post> e : post_map.entrySet())
			if(e.getKey() > maxKey){
				maxKey = e.getKey();
			}
		for (Map.Entry<Integer, Comment> e : commentMap.entrySet())
			if(e.getKey() > maxKey){
				maxKey = e.getKey();
			}
		int idValue = maxKey + 1;
		Post output_post = new Post(handle, idValue, message) ;
		post_map.put(idValue, (output_post));
		post_id_map.put(handle, idValue);
		account_map.get(id_map.get(handle)).postNumber = account_map.get(id_map.get(handle)).postNumber + 1;
		return idValue;
	}

	@Override
	public int endorsePost(String handle, int id)
			throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
		// TODO Final check
		int maxKey = 0;
		for (Map.Entry<Integer, Endorsement> e : endorsementMap.entrySet())
			if(e.getKey() > maxKey){
				maxKey = e.getKey();
			}
		int idValue = maxKey + 1;
		String outputHandle = post_map.get(id).handle;
		String outputMessage = post_map.get(id).post_message;
		Endorsement outputEndorsement = new Endorsement(idValue, handle, outputHandle, outputMessage);
		endorsementMap.put(idValue, outputEndorsement);
		endorsementIdMap.put(handle, idValue);
		account_map.get(id_map.get(outputHandle)).account_popularity = account_map.get(id_map.get(outputHandle)).account_popularity + 1;
		post_map.get(id).post_popularity = post_map.get(id).post_popularity + 1;
		return idValue;
	}

	@Override
	public int endorseComment(String handle, int id)
			throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
		// TODO Final check
		int maxKey = 0;
		for (Map.Entry<Integer, Endorsement> e : endorsementMap.entrySet())
			if(e.getKey() > maxKey){
				maxKey = e.getKey();
			}
		int idValue = maxKey + 1;
		String outputHandle = commentMap.get(id).handle;
		String outputMessage = commentMap.get(id).commentMessage;
		Endorsement outputEndorsement = new Endorsement(idValue, handle, outputHandle, outputMessage);
		endorsementMap.put(idValue, outputEndorsement);
		endorsementIdMap.put(handle, idValue);
		account_map.get(id_map.get(outputHandle)).account_popularity = account_map.get(id_map.get(outputHandle)).account_popularity + 1;
		commentMap.get(id).commentPopularity = commentMap.get(id).commentPopularity + 1;
		return idValue;
	}

	@Override
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException,
			PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
		// TODO Final check
		int maxKey = 0;
		for (Map.Entry<Integer, Post> e : post_map.entrySet())
			if(e.getKey() > maxKey){
				maxKey = e.getKey();
			}
		for (Map.Entry<Integer, Comment> e : commentMap.entrySet())
			if(e.getKey() > maxKey){
				maxKey = e.getKey();
			}
		int idValue = maxKey + 1;
		Comment outputComment = new Comment(idValue, handle, id, message);
		commentMap.put(idValue, outputComment);
		commentIdMap.put(handle, id);
		account_map.get(id_map.get(handle)).postNumber = account_map.get(id_map.get(handle)).postNumber + 1;
		return idValue;
	}

	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		// TODO Final check
		//int idValue = post_id_map.get(id);
		post_id_map.remove(post_map.get(id).handle);
		post_map.remove(id);

	}
	@Override
	public void deleteComment(int id) throws PostIDNotRecognisedException {
		// TODO Final check
		//int idValue = commentIdMap.get(id);
		commentIdMap.remove(commentMap.get(id).handle);
		commentMap.remove(id);
	}
	@Override
	public void deleteEndorsement(int id) throws PostIDNotRecognisedException {
		// TODO Final check
		//int idValue = post_id_map.get(id);
		endorsementIdMap.remove(endorsementMap.get(id).handle);
		endorsementMap.remove(id);
	}

	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {
		// TODO Final check
		int idValue = post_id_map.get(id);
		return post_map.get(idValue).toString();
	}

	@Override
	public StringBuilder showPostChildrenDetails(int id)
			throws PostIDNotRecognisedException, NotActionablePostException {
		// TODO Auto-generated method stub
		StringBuilder family = new StringBuilder();
		if (post_map.get(id) != null) {
			family.append(post_map.get(id) + "\n");
		} else if (commentMap.get(id) != null) {
			family.append(commentMap.get(id) + "\n");
		} else {
			throw new PostIDNotRecognisedException();
		}

		for (Map.Entry<Integer, Comment> e : commentMap.entrySet())
			if(e.getValue().parentPostID == id){
				family.append("|".indent(5) + e.getValue().toString().indent(5));
				for (Map.Entry<Integer, Comment> f : commentMap.entrySet())
					if(f.getValue().parentPostID == e.getKey()) {
						family.append("|".indent(10) + f.getValue().toString().indent(10));
						for (Map.Entry<Integer, Comment> g : commentMap.entrySet())
							if(g.getValue().parentPostID == f.getKey()) {
								family.append("|".indent(15) + g.getValue().toString().indent(15));
								for (Map.Entry<Integer, Comment> h : commentMap.entrySet())
									if(h.getValue().parentPostID == g.getKey()) {
										family.append("|".indent(15) + h.getValue().toString().indent(15));
										for (Map.Entry<Integer, Comment> i : commentMap.entrySet())
											if(i.getValue().parentPostID == h.getKey()) {
												family.append("|".indent(15) + "\n More comments in chain");
											}
									}
							}
					}
			}
		return family;
	}

	@Override
	public int getNumberOfAccounts() {
		// TODO Final check
		return account_map.size();
	}

	@Override
	public int getTotalOriginalPosts() {
		// TODO Final check
		return post_map.size();
	}

	@Override
	public int getTotalEndorsmentPosts() {
		// TODO Final check
		return endorsementMap.size();
	}

	@Override
	public int getTotalCommentPosts() {
		// TODO Final check
		return commentMap.size();
	}

	@Override
	public int getMostEndorsedPost() {
		// TODO Final check
		int max = 0;
		int maxKey = 0;
		for (Map.Entry<Integer, Post> e : post_map.entrySet())
			if(e.getValue().post_popularity > max){
				max = e.getValue().post_popularity;
				maxKey = e.getKey();
			}
		return maxKey;
	}

	@Override
	public int getMostEndorsedAccount() {
		// TODO Final check
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
		// TODO Final check
		post_map.clear();
		post_id_map.clear();
		account_map.clear();
		id_map.clear();
		endorsementMap.clear();
		endorsementIdMap.clear();
		commentMap.clear();
		commentIdMap.clear();
	}

	@Override
	public void savePlatform(String filename) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Saving platform... ");
		FileOutputStream myFileOutStream = new FileOutputStream(filename + ".ser");
        	ObjectOutputStream myObjectOutStream = new ObjectOutputStream(myFileOutStream);
        	myObjectOutStream.writeObject(post_map);
		myObjectOutStream.writeObject(post_id_map);
		myObjectOutStream.writeObject(account_map);
		myObjectOutStream.writeObject(id_map);
		myObjectOutStream.writeObject(endorsementMap);
		myObjectOutStream.writeObject(endorsementIdMap);
		myObjectOutStream.writeObject(commentMap);
		myObjectOutStream.writeObject(commentIdMap);
		myObjectOutStream.close();
		myFileOutStream.close();
		System.out.println("Platform saved!" + 
						"\nIt has been saved in your current working directory under filename: "+ filename);
	}

	@Override
	public void loadPlatform(String filename) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
	FileInputStream fis = new FileInputStream(filename + ".ser");
	ObjectInputStream ois = new ObjectInputStream(fis);
	ois.readObject();
    	ois.close();
   	fis.close();
	}

}

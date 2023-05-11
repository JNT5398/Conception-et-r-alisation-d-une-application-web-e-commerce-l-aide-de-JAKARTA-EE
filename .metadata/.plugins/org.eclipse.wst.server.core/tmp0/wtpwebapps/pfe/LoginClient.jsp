<main id="rightCol">
			<form method="post" action="connectionClient.do">
				<h1 align="center">Se Connecter</h1>
				<div><h3  align="center">Client:</h3></div>
				<div>
					<p>
						<label for="Email_Client">Login : <span>*</span></label> <input
							type="email" name="Email_Client" id="Email_Client" value=""
							required="required" />
					</p>
					<p>
						<label for="Password">Mot de passe : <span>*</span></label>
						<input type="password" name="PassWord_Client" id="Password"
							value="" required="required" />
					</p>
					<input type="submit" value="Connecter" />
					<p class="p"></p>
					<span>*</span> : Les champs indiqués par une <span>*</span> sont
					obligatoires .
					<p class="p"></p>
				</div>
			</form>
</main>
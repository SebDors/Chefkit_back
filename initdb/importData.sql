INSERT INTO
    ingredients (nom_ingredient, categorie)
VALUES ('Tomate', 'légume'),
    ('Oignon', 'légume'),
    ('Poulet', 'Autre'),
    ('Huile de Tournesol', 'Autre'),
    ('Sel', 'Autre'),
    ('Poivre noir', 'Autre'),
    ('Pain', 'Autre'),
    ('Beurre', 'Autre'),
    ('Lait', 'Autre'),
    ('Sucre', 'Autre'),
    ('Farine', 'Autre'),
    ('Œufs', 'Autre'),
    ('Levure', 'Autre'),
    ('Chocolat', 'Autre'),
    ('Vanille', 'Autre'),
    ('Avocat', 'fruit'),
    ('Citron', 'fruit'),
    ('Concombre', 'légume'),
    ('Carotte', 'légume'),
    ('Poivron', 'légume'),
    ('Fromage', 'Autre'),
    ('Jambon', 'Autre'),
    ('Saumon', 'Autre'),
    ('Riz', 'Autre'),
    ('Pâtes', 'Autre'),
    ('Pommes de terre', 'légume'),
    ('Épinards', 'légume'),
    ('Champignons', 'légume'),
    ('Yaourt', 'Autre'),
    ('Crème fraîche', 'Autre'),
    ('Curry', 'Autre'),
    ('Gingembre', 'Autre'),
    ('Sauce soja', 'Autre'),
    ('Bouillon', 'Autre'),
    (
        'Pâte (pizza/feuilletée/brisée)',
        'Autre'
    ),
    ('Fruits rouges', 'fruit'),
    ('Crème pâtissière', 'Autre'),
    ('Pomme', 'fruit'),
    ('Banane', 'fruit'),
    ('Steak', 'Autre'),
    ('Chou-fleur', 'légume'),
    ('Courgette', 'légume'),
    ('Aubergine', 'légume'),
    ('Frites surgelées', 'Autre'),
    ('Herbes de Provence', 'Autre'),
    ('Steak vegetarien', 'Autre'),
    ('Salade', 'légume'),
    ('Pain de mie', 'Autre'),
    ('Crème liquide', 'Autre'),
    ('Gelatine', 'Autre'),
    ('Lait de coco', 'Autre'),
    ('Echalote', 'légume'),
    ('Tortilla', 'Autre'),
    ('Menthe', 'Autre'),
    ('Tofu', 'Autre'),
    ('Sauce Tomate', 'Autre'),
    ('Nouilles de riz', 'Autre'),
    ('Pain Burger', 'Autre'),
    ('Bechamel', 'Autre'),
    ('Ail', 'légume'),
    (
        'Lentilles de corail',
        'légume'
    ),
    ('Crevettes', 'Autre'),
    ('Orange', 'fruit'),
    ('Fraise', 'fruit'),
    ('Framboise', 'fruit'),
    ('Pêche', 'fruit'),
    ('Abricot', 'fruit'),
    ('Raisin', 'fruit'),
    ('Mangue', 'fruit'),
    ('Ananas', 'fruit'),
    ('Kiwi', 'fruit'),
    ('Brocoli', 'légume'),
    ('Haricots verts', 'légume'),
    ('Petits pois', 'légume'),
    ('Asperge', 'légume'),
    ('Artichaut', 'légume'),
    ('Betterave', 'légume'),
    ('Céleri', 'légume'),
    ('Radis', 'légume'),
    ('Endive', 'légume');

INSERT INTO
    utilisateurs (
        nom_utilisateur,
        email,
        mot_de_passe,
        role
    )
VALUES (
        'seb',
        'dorssebastien@gmail.com',
        'password',
        'admin'
    ),
    (
        'margault',
        'margaultmons@gmail.com',
        'password',
        'admin'
    ),
    (
        'camille',
        'camgra@gmail.com',
        'password',
        'admin'
    ),
    (
        'test',
        'testtest@gmail.com',
        'password',
        'user'
    );

INSERT INTO
    recettes (
        titre,
        description,
        instructions,
        temps_preparation_minutes,
        temps_cuisson_minutes,
        nombre_personnes,
        path_image
    )
VALUES (
        'Avocado Toast',
        'Une tartine à l''avocat simple et délicieuse, parfaite pour le petit-déjeuner ou le brunch.',
        '1. Faites griller le pain. 2. Écrasez l''avocat dans un bol et assaisonnez avec du sel, du poivre et du jus de citron. 3. Étalez l''avocat sur le pain grillé et ajoutez des toppings au choix.',
        5,
        5,
        1,
        '/assets/images/avocado_toast.jpg'
    ),
    (
        'Pizza Regina',
        'Une délicieuse pizza garnie de sauce tomate, mozzarella, jambon et champignons.',
        '1. Préchauffez le four à 220°C. 2. Étalez la pâte à pizza sur une plaque de cuisson. 3. Étalez la sauce tomate sur la pâte, puis ajoutez la mozzarella, le jambon et les champignons. 4. Enfournez pendant 12-15 minutes jusqu''à ce que la pâte soit dorée.',
        20,
        15,
        2,
        '/assets/images/pizza_regina.jpg'
    ),
    (
        'Soupe froide de concombre',
        'Une soupe rafraîchissante à base de concombre, yaourt et menthe.',
        '1. Épluchez et coupez les concombres en morceaux. 2. Dans un mixeur, ajoutez les concombres, le yaourt, la menthe, le sel et le poivre. 3. Mixez jusqu''à obtenir une consistance lisse. 4. Réfrigérez pendant au moins 30 minutes avant de servir.',
        10,
        0,
        4,
        '/assets/images/recipe-soupe_concombre.jpg'
    ),
    (
        'Pancakes aux myrtilles',
        'Des pancakes moelleux garnis de myrtilles fraîches, parfaits pour le petit-déjeuner.',
        '1. Dans un bol, mélangez la farine, le sucre, la levure chimique et une pincée de sel. 2. Dans un autre bol, battez l''œuf, puis ajoutez le lait et le beurre fondu. 3. Incorporez les ingrédients secs aux ingrédients liquides jusqu''à obtenir une pâte homogène. 4. Ajoutez les myrtilles à la pâte. 5. Faites chauffer une poêle antiadhésive et versez des petites louches de pâte pour former les pancakes. Faites cuire jusqu''à ce que des bulles se forment à la surface, puis retournez-les et faites cuire l''autre côté jusqu''à ce qu''il soit doré.',
        10,
        5,
        4,
        '/assets/images/pancakes_myrtilles.jpg'
    ),
    (
        'Moelleux au chocolat',
        'Un dessert riche et fondant au chocolat, parfait pour les amateurs de chocolat.',
        '1. Préchauffez le four à 180°C. 2. Faites fondre le chocolat et le beurre au bain-marie. 3. Dans un bol, battez les œufs et le sucre jusqu''à ce que le mélange blanchisse. 4. Incorporez le mélange chocolat-beurre, puis ajoutez la farine. 5. Versez la pâte dans des moules individuels et enfournez pendant 10-12 minutes.',
        15,
        30,
        6,
        '/assets/images/recipe-moelleux_aux_chocolats.jpg'
    ),
    (
        'Tartelette aux fraises',
        'De délicieuses tartelettes garnies de fraises fraîches et de crème pâtissière.',
        '1. Préchauffez le four à 180°C. 2. Étalez la pâte feuilletée dans des moules à tartelette et faites cuire à blanc pendant 15 minutes. 3. Préparez la crème pâtissière en chauffant le lait avec la vanille, puis en mélangeant les jaunes d''œufs, le sucre et la farine avant d''incorporer le lait chaud. 4. Laissez refroidir la crème pâtissière, puis garnissez les tartelettes avec la crème et disposez les fraises sur le dessus.',
        30,
        15,
        4,
        '/assets/images/recipe-tartelette_à_la_fraise.jpg'
    ),
    (
        'Steak frites',
        'Un classique français avec un steak juteux et des frites croustillantes.',
        '1. Assaisonnez le steak avec du sel et du poivre. 2. Faites chauffer une poêle avec un peu d''huile et faites cuire le steak à votre goût. 3. Pendant ce temps, faites cuire les frites surgelées selon les instructions du paquet. 4. Servez le steak avec les frites et une salade verte.',
        10,
        15,
        2,
        '/assets/images/recipe-steak_frites.jpg'
    ),
    (
        'Burger vegétarien',
        'Un burger savoureux avec un steak végétarien, du fromage et des légumes frais.',
        '1. Faites griller le steak végétarien selon les instructions du paquet. 2. Faites légèrement griller les pains à burger. 3. Garnissez le pain inférieur avec de la salade, une tranche de tomate, le steak végétarien, une tranche de fromage, des rondelles d''oignon et de la sauce de votre choix. 4. Couvrez avec le pain supérieur et servez avec des frites ou une salade.',
        15,
        10,
        2,
        '/assets/images/recipe-burger_végétal.jpg'
    ),
    (
        'Croque monsieur',
        'Un sandwich chaud classique français avec du jambon et du fromage fondu.',
        '1. Préchauffez le grill. 2. Tartinez les tranches de pain de beurre. 3. Disposez une tranche de jambon et une tranche de fromage entre deux tranches de pain. 4. Faites griller le sandwich jusqu''à ce qu''il soit doré et le fromage fondu.',
        10,
        5,
        2,
        '/assets/images/recipe-croque_monsieur.jpg'
    ),
    (
        'Pad Thaï à l''oeuf',
        'Un plat thaïlandais populaire à base de nouilles de riz sautées avec des crevettes, du tofu, des œufs et des légumes.',
        '1. Faites tremper les nouilles de riz dans de l''eau chaude pendant 30 minutes. 2. Dans un wok, faites chauffer de l''huile et ajoutez les crevettes et le tofu. 3. Ajoutez les œufs battus et les nouilles égouttées. 4. Incorporez la sauce soja et les légumes. 5. Faites sauter le tout pendant quelques minutes et servez chaud.',
        30,
        15,
        4,
        '/assets/images/recipe-pad_thai_oeuf.jpg'
    ),
    (
        'Lasagnes végétariennes',
        'Des lasagnes savoureuses avec des légumes grillés, de la sauce tomate et de la béchamel.',
        '1. Préchauffez le four à 180°C. 2. Faites griller les légumes (courgettes, aubergines, poivrons) et préparez la sauce tomate. 3. Préparez la béchamel en chauffant le lait avec du beurre et de la farine. 4. Dans un plat à gratin, alternez des couches de pâtes à lasagne, de légumes grillés, de sauce tomate et de béchamel. 5. Terminez par une couche de béchamel et saupoudrez de fromage râpé.',
        60,
        45,
        6,
        '/assets/images/recipe-lasagnes_aux_légumes_de_soleil.jpg'
    ),
    (
        'Poke bowl végétarien',
        'Un bol coloré et sain avec du riz, des légumes frais et du tofu mariné.',
        '1. Faites cuire le riz selon les instructions du paquet. 2. Pendant ce temps, préparez les légumes (avocat, concombre, carotte) en les coupant en dés. 3. Faites mariner le tofu dans de la sauce soja et du gingembre. 4. Dans un bol, disposez le riz, les légumes et le tofu. 5. Arrosez de sauce soja et servez frais.',
        30,
        15,
        1,
        '/assets/images/recipe-vegan_poke_bowl.jpg'
    ),
    (
        'Tarte tatin aux pommes',
        'Une tarte renversée aux pommes caramélisées, un dessert classique français.',
        '1. Préchauffez le four à 180°C. 2. Dans une poêle, faites fondre le sucre jusqu''à obtenir un caramel doré. 3. Ajoutez les pommes coupées en quartiers et faites-les cuire dans le caramel pendant quelques minutes. 4. Disposez les pommes caramélisées dans un moule à tarte et recouvrez-les de pâte brisée. 5. Enfournez pendant 30-35 minutes jusqu''à ce que la pâte soit dorée. 6. Laissez refroidir légèrement avant de démouler en retournant la tarte sur une assiette.',
        20,
        35,
        6,
        '/assets/images/recipe-tarte_tatin_aux_pommes.jpg'
    ),
    (
        'Tacos au poulet',
        'Des tacos savoureux garnis de poulet épicé, de légumes frais et de sauce.',
        '1. Faites cuire les aiguillettes de poulet avec des épices mexicaines. 2. Réchauffez les tortillas de maïs. 3. Garnissez chaque tortilla avec le poulet, de la laitue, des tomates, du fromage et de la sauce.',
        20,
        10,
        4,
        '/assets/images/recipe-tacos_poulet.jpg'
    ),
    (
        'Soupe lentilles corail coco',
        'Une soupe réconfortante à base de lentilles corail et de lait de coco, parfumée aux épices.',
        '1. Rincez les lentilles corail. 2. Dans une casserole, faites revenir l''ail et l''échalote hachés dans un peu d''huile. 3. Ajoutez les lentilles, le lait de coco, le bouillon de légumes, le curry, le sel et le poivre. 4. Laissez mijoter pendant 20-25 minutes jusqu''à ce que les lentilles soient tendres. 5. Mixez la soupe jusqu''à obtenir une consistance lisse et servez chaud.',
        10,
        15,
        4,
        '/assets/images/recipe-soupe_lentilles_corail_ coco.jpg'
    ),
    (
        'Pates à la bolognaise',
        'Des pâtes savoureuses servies avec une sauce bolognaise riche en viande et en tomates.',
        '1. Faites cuire les pâtes selon les instructions du paquet. 2. Dans une poêle, faites revenir l''oignon et l''ail hachés dans un peu d''huile. 3. Ajoutez la viande hachée et faites-la cuire jusqu''à ce qu''elle soit dorée. 4. Incorporez la sauce tomate, le sel, le poivre et les herbes de Provence. Laissez mijoter pendant 15-20 minutes. 5. Servez la sauce bolognaise sur les pâtes chaudes, garnie de parmesan râpé.',
        20,
        15,
        4,
        '/assets/images/recipe-pasta.jpg'
    ),
    (
        'Panacotta à la vanille',
        'Un dessert crémeux à base de lait, de crème et de sucre, parfumé à la vanille.',
        '1. Dans une casserole, faites chauffer le lait et la crème avec la vanille. 2. Dans un bol, mélangez le sucre et la gélatine. 3. Incorporez le mélange de lait chaud au mélange de sucre et de gélatine. 4. Versez dans des verrines et laissez refroidir au réfrigérateur pendant au moins 4 heures.',
        20,
        15,
        4,
        '/assets/images/recipe-panna_cotta.jpg'
    ),
    (
        'Gratin de chou-fleur',
        'Un gratin savoureux à base de chou-fleur, de béchamel et de fromage râpé.',
        '1. Préchauffez le four à 180°C. 2. Faites cuire le chou-fleur à la vapeur jusqu''à ce qu''il soit tendre. 3. Préparez la béchamel en chauffant le lait avec du beurre et de la farine. 4. Dans un plat à gratin, disposez le chou-fleur et nappez-le de béchamel. 5. Saupoudrez de fromage râpé et enfournez pendant 25-30 minutes jusqu''à ce que le gratin soit doré.',
        20,
        30,
        4,
        '/assets/images/recipe-chou_fleur_fromage.jpg'
    );

INSERT INTO
    recette_ingredients (
        id_recette,
        id_ingredient,
        quantite,
        unite
    )
VALUES
    -- Recette 1: Avocado Toast
    (1, 16, '1', 'unité'),
    (1, 7, '2', 'tranches'),
    (1, 5, '1', 'pincée'),
    (1, 6, '1', 'pincée'),
    (1, 17, '0.5', 'unité'),
    -- Recette 2: Pizza Regina
    (2, 35, '1', 'unité'),
    (2, 56, '200', 'g'),
    (2, 21, '125', 'g'),
    (2, 22, '2', 'tranches'),
    (2, 28, '100', 'g'),
    -- Recette 3: Soupe froide de concombre
    (3, 18, '1', 'unité'),
    (3, 29, '1', 'pot'),
    (3, 54, '10', 'feuilles'),
    (3, 5, '1', 'pincée'),
    (3, 6, '1', 'pincée'),
    -- Recette 4: Pancakes aux myrtilles
    (4, 11, '250', 'g'),
    (4, 10, '50', 'g'),
    (4, 13, '1', 'sachet'),
    (4, 5, '1', 'pincée'),
    (4, 12, '2', 'unités'),
    (4, 9, '30', 'cl'),
    (4, 8, '50', 'g'),
    (4, 36, '100', 'g'),
    -- Recette 5: Moelleux au chocolat
    (5, 14, '200', 'g'),
    (5, 8, '150', 'g'),
    (5, 12, '4', 'unités'),
    (5, 10, '100', 'g'),
    (5, 11, '50', 'g'),
    -- Recette 6: Tartelette aux fraises
    (6, 35, '1', 'rouleau'),
    (6, 37, '250', 'ml'),
    (6, 64, '250', 'g'),
    -- Recette 7: Steak frites
    (7, 40, '2', 'unités'),
    (7, 44, '500', 'g'),
    (7, 47, '100', 'g'),
    (7, 5, '1', 'pincée'),
    (7, 6, '1', 'pincée'),
    -- Recette 8: Burger vegétarien
    (8, 46, '2', 'unités'),
    (8, 58, '2', 'unités'),
    (8, 21, '2', 'tranches'),
    (8, 47, '50', 'g'),
    (8, 1, '4', 'tranches'),
    (8, 2, '1', 'unité'),
    -- Recette 9: Croque monsieur
    (9, 48, '4', 'tranches'),
    (9, 22, '2', 'tranches'),
    (9, 21, '50', 'g'),
    (9, 8, '20', 'g'),
    -- Recette 10: Pad Thaï à l'oeuf
    (10, 57, '200', 'g'),
    (10, 62, '150', 'g'),
    (10, 55, '100', 'g'),
    (10, 12, '2', 'unités'),
    (10, 33, '60', 'ml'),
    (10, 19, '1', 'unité'),
    (10, 2, '1', 'unité'),
    -- Recette 11: Lasagnes végétariennes
    (11, 25, '12', 'feuilles'),
    (11, 42, '1', 'unité'),
    (11, 43, '1', 'unité'),
    (11, 20, '1', 'unité'),
    (11, 56, '400', 'g'),
    (11, 59, '500', 'ml'),
    (11, 21, '150', 'g'),
    -- Recette 12: Poke bowl végétarien
    (12, 24, '150', 'g'),
    (12, 16, '0.5', 'unité'),
    (12, 18, '0.5', 'unité'),
    (12, 19, '1', 'unité'),
    (12, 55, '150', 'g'),
    (12, 33, '30', 'ml'),
    (12, 32, '1', 'c.à.c.'),
    -- Recette 13: Tarte tatin aux pommes
    (13, 38, '6', 'unités'),
    (13, 10, '150', 'g'),
    (13, 35, '1', 'rouleau'),
    -- Recette 14: Tacos au poulet
    (14, 3, '400', 'g'),
    (14, 53, '8', 'unités'),
    (14, 47, '100', 'g'),
    (14, 1, '2', 'unités'),
    (14, 21, '100', 'g'),
    -- Recette 15: Soupe lentilles corail coco
    (15, 61, '200', 'g'),
    (15, 51, '400', 'ml'),
    (15, 34, '1', 'cube'),
    (15, 60, '2', 'gousses'),
    (15, 52, '1', 'unité'),
    (15, 31, '1', 'c.à.s.'),
    (15, 5, '1', 'pincée'),
    (15, 6, '1', 'pincée'),
    -- Recette 16: Pates à la bolognaise
    (16, 25, '400', 'g'),
    (16, 2, '1', 'unité'),
    (16, 60, '2', 'gousses'),
    (16, 40, '400', 'g'),
    (16, 56, '400', 'g'),
    (16, 5, '1', 'pincée'),
    (16, 6, '1', 'pincée'),
    (16, 45, '1', 'c.à.c.'),
    -- Recette 17: Panacotta à la vanille
    (17, 9, '250', 'ml'),
    (17, 49, '250', 'ml'),
    (17, 15, '1', 'gousse'),
    (17, 10, '80', 'g'),
    (17, 50, '3', 'feuilles'),
    -- Recette 18: Gratin de chou-fleur
    (18, 41, '1', 'unité'),
    (18, 59, '500', 'ml'),
    (18, 21, '100', 'g'),
    (18, 5, '1', 'pincée'),
    (18, 6, '1', 'pincée');

INSERT INTO
    frigo_utilisateur (id_utilisateur, id_ingredient)
VALUES (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    (1, 6),
    (1, 7),
    (1, 8),
    (1, 12),
    (1, 21),
    (2, 19),
    (2, 20),
    (2, 9),
    (2, 28),
    (2, 23),
    (2, 22),
    (2, 25),
    (2, 24),
    (3, 37),
    (3, 36),
    (3, 14),
    (3, 11),
    (3, 10),
    (3, 49),
    (3, 29);
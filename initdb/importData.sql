INSERT INTO
    ingredients (nom_ingredient)
VALUES ('Tomate'),
    ('Oignon'),
    ('Poitrine de poulet'),
    ('Huile de Tournesol'),
    ('Sel'),
    ('Poivre noir'),
    ('Basilic'),
    ('Origan'),
    ('Parmesan'),
    ('Pain'),
    ('Beurre'),
    ('Lait'),
    ('Sucre'),
    ('Farine'),
    ('Œufs'),
    ('Levure'),
    ('Chocolat'),
    ('Vanille'),
    ('Avocat'),
    ('Citron'),
    ('Concombre'),
    ('Carotte'),
    ('Poivron'),
    ('Fromage'),
    ('Jambon'),
    ('Saumon'),
    ('Riz'),
    ('Pates'),
    ('Pommes de terre'),
    ('Épinards'),
    ('Champignons'),
    ('Noix'),
    ('Amandes'),
    ('Miel'),
    ('Yaourt'),
    ('Crème fraîche'),
    ('Ciboulette'),
    ('Persil'),
    ('Coriandre'),
    ('Thym'),
    ('Romarin'),
    ('Curry'),
    ('Paprika'),
    ('Cumin'),
    ('Gingembre'),
    ('Cannelle'),
    ('Clou de girofle'),
    ('Piment de Cayenne'),
    ('Noix de muscade'),
    ('Anis étoilé'),
    ('Fenouil'),
    ('Cardamome'),
    ('Safran'),
    ('Curcuma'),
    ('Moutarde'),
    ('Vinaigre balsamique'),
    ('Sauce soja'),
    ('Bouillon de poulet'),
    ('Bouillon de bœuf'),
    ('Pate à pizza'),
    ('Jambon de parme'),
    ('Pancakes'),
    ('Myrtille'),
    ('Chorizo'),
    ('Mozzarella'),
    ('Ricotta'),
    ('Feta'),
    ('Gorgonzola'),
    ('Roquefort'),
    ('Gruyère'),
    ('Comté'),
    ('Emmental'),
    ('Cantal'),
    ('Saint-Nectaire'),
    ('Reblochon'),
    ('Tomme de Savoie'),
    ('Brie'),
    ('Camembert'),
    ('Chèvre'),
    ('Pate feuilletée'),
    ('Pate brisée'),
    ('Pate sablée'),
    ('Crème pâtissière'),
    ('Chantilly'),
    ('Glace à la vanille'),
    ('Glace au chocolat'),
    ('Glace à la fraise'),
    ('Sorbet au citron'),
    ('Sorbet à la framboise'),
    ('Fraise'),
    ('Framboise'),
    ('Mûre'),
    ('Cerise'),
    ('Pomme'),
    ('Poire'),
    ('Banane'),
    ('Orange'),
    ('Mandarine'),
    ('Clémentine'),
    ('Pamplemousse'),
    ('Ananas'),
    ('Mangue'),
    ('Kiwi'),
    ('Noix de coco'),
    ('Fruit de la passion'),
    ('Grenade'),
    ('Raisin'),
    ('Creme anglaise'),
    ('Steak'),
    ('Filet de saumon'),
    ('Filet de cabillaud'),
    ('Moules'),
    ('Calamars'),
    ('Thon en conserve'),
    ('Sardines en conserve'),
    ('Maquereau en conserve'),
    ('Laitue'),
    ('Roquette'),
    ('Chou kale'),
    ('Chou-fleur'),
    ('Brocoli'),
    ('Asperges'),
    ('Haricots verts'),
    ('Petits pois'),
    ('Maïs'),
    ('Betterave'),
    ('Radis'),
    ('Navet'),
    ('Courgette'),
    ('Aubergine'),
    ('Citrouille'),
    ('Potiron'),
    ('Patate douce'),
    ('Céleri'),
    ('Fenouil cru'),
    ('frites surgelées'),
    ('Herbe de provence'),
    ('Steak vegetarien'),
    ('Salade'),
    ('Pain de mie'),
    ('Creme liquide'),
    ('Gelatine'),
    ('Fruits rouges'),
    ('Poudre de cacao'),
    ('Chocolat Noir'),
    ('Chocolat Blanc'),
    ('Chocolat au Lait'),
    ('Noix de Pecans'),
    ('Bacon'),
    ('Cheddar'),
    ('Burrrata'),
    ('Aiguillettes de poulet'),
    ('Escalope de veau'),
    ('Cuisse de poulet'),
    ('Filet mignon de porc'),
    ('Poitrine de porc'),
    ('Saucisse'),
    ('Chipolata'),
    ('Merguez'),
    ('Curry vert'),
    ('Curry rouge'),
    ('Lait de coco'),
    ('Echalote'),
    ('Sauce barbecue'),
    ('Tortillade de mais'),
    ('Quinoa'),
    ('Tomates cerise'),
    ('Menthe'),
    ('Boulette de pomme de terre'),
    ('Haricots'),
    ('Mais'),
    ('Toffu'),
    ('Sauce Tomate'),
    ('Nouilles de riz'),
    ('Germe de soja'),
    ('Pain Burger'),
    ('Pates à lasagne'),
    ('Bechamel'),
    ('Ail'),
    ('Lentilles de corail'),
    ('Bouillon de legumes'),
    ('Piment rouge'),
    ('Crevettes'),
    ('Spaguetti');

INSERT INTO
    utilisateurs (
        nom_utilisateur,
        email,
        mot_de_passe
    )
VALUES (
        'seb',
        'dorssebastien',
        'password'
    ),
    (
        'margault',
        'margaultmons',
        'password'
    ),
    (
        'camille',
        'camgra',
        'password'
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
        '/assets/images/soupe_concombre.jpg'
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
        '/assets/images/moelleux_chocolat.jpg'
    );

INSERT INTO
    recette_ingredients (
        id_recette,
        id_ingredient,
        quantite,
        unite
    )
VALUES
    -- Avocado Toast (recette_id=1)
    (1, 19, '1', 'unité'), -- Avocat
    (1, 10, '2', 'tranches'), -- Pain
    (1, 5, '1', 'pincée'), -- Sel
    (1, 6, '1', 'pincée'), -- Poivre noir
    (1, 20, '0.5', 'unité'), -- Citron
    -- Pizza Regina (recette_id=2)
    (2, 61, '1', 'unité'), -- Pate à pizza
    (2, 183, '200', 'g'), -- Sauce Tomate (CORRIGÉ: ID 199 au lieu de 200)
    (2, 66, '125', 'g'), -- Mozzarella
    (2, 25, '2', 'tranches'), -- Jambon
    (2, 31, '50', 'g'), -- Champignons
    -- Soupe froide de concombre (recette_id=3)
    (3, 21, '1', 'unité'), -- Concombre
    (3, 35, '1', 'pot'), -- Yaourt
    (3, 180, '10', 'feuilles'), -- Menthe
    (3, 5, '1', 'pincée'), -- Sel
    (3, 6, '1', 'pincée'), -- Poivre noir
    -- Pancakes aux myrtilles (recette_id=4)
    (4, 14, '250', 'g'), -- Farine
    (4, 13, '50', 'g'), -- Sucre
    (4, 16, '1', 'sachet'), -- Levure
    (4, 5, '1', 'pincée'), -- Sel
    (4, 15, '2', 'unités'), -- Œufs
    (4, 12, '30', 'cl'), -- Lait
    (4, 11, '50', 'g'), -- Beurre
    (4, 64, '100', 'g'), -- Myrtille
    -- Moelleux au chocolat (recette_id=5)
    (5, 17, '200', 'g'), -- Chocolat
    (5, 11, '150', 'g'), -- Beurre
    (5, 15, '4', 'unités'), -- Œufs
    (5, 13, '100', 'g'), -- Sucre
    (5, 14, '50', 'g');
-- Farine